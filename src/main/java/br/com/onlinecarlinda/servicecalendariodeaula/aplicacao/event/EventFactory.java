package br.com.onlinecarlinda.servicecalendariodeaula.aplicacao.event;

import java.time.LocalDateTime;
import java.util.UUID;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;

public interface EventFactory extends ApplicationEventPublisher{
		
	UUID getEventId();
	
	LocalDateTime getDataHoraEvento();
	
	EventFactory getEventFactory(ApplicationContext context);
}
