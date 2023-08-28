package com.souza.caio.strconsumer.listeners;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.souza.caio.strconsumer.custom.StrConsumerCustomListener;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class StrConsumerListener {
	
	@StrConsumerCustomListener(groupId="group-1")
	public void create(String message) {
		log.info("CREATE ::: Receive message{}", message);
	}
	
	@StrConsumerCustomListener(groupId="group-1")
	public void log(String message) {
		log.info("LOG ::: Receive message{}", message);
	}
	
	@KafkaListener(groupId="group-2", topics = "str-topic" ,containerFactory = "validMessageContainerFactory")
	public void history(String message) {
		log.info("HISTORY", message);
	}
}
