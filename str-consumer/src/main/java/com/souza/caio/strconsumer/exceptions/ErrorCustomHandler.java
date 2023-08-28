package com.souza.caio.strconsumer.exceptions;

import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class ErrorCustomHandler implements KafkaListenerErrorHandler{

	@Override
	public Object handleError(Message<?> message, ListenerExecutionFailedException exception) {
		log.info("EXCEPTION HANDLER ::: Error cathced");
		log.info("Payload ::: {}", message.getPayload());
		log.info("Headers ::: {}", message.getHeaders());
		return null;
	}

	
	/*@Override
	public Object handleError(Message<?> message, ListenerExecutionFailedException exception,
			Consumer<?, ?> consumer) {

		return handleError(message, exception);
	}*/
}
