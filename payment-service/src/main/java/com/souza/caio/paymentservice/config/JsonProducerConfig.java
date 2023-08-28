package com.souza.caio.paymentservice.config;

import java.io.Serializable;
import java.util.HashMap;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
public class JsonProducerConfig {

	private final KafkaProperties properties;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public ProducerFactory jsonProducerFactory() {
		HashMap<String, Object> configs = new HashMap<>();
		configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, properties.getBootstrapServers());
		configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		return new DefaultKafkaProducerFactory(configs, new StringSerializer(), new JsonSerializer());
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Bean
	public KafkaTemplate<String, Serializable> jsonKafkaTemplate(ProducerFactory producerFactory){
		return new KafkaTemplate<>(producerFactory);
	}
}
