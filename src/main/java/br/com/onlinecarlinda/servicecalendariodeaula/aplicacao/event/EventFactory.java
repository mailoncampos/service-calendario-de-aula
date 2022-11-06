package br.com.onlinecarlinda.servicecalendariodeaula.aplicacao.event;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public interface EventFactory{
	
	UUID eventId = UUID.randomUUID();
	
	LocalDateTime dataHoraEvento = LocalDateTime.now();
	
	Object getObject();
	
	String getTipoEvento();
	
	void setObject(Object object);
	
}
