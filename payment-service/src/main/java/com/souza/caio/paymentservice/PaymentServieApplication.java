package com.souza.caio.paymentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class PaymentServieApplication {
	public static void main(String[] args) {
		SpringApplication.run(PaymentServieApplication.class, args);
	}
}
