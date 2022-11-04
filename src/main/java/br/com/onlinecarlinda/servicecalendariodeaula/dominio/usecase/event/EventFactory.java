package br.com.onlinecarlinda.servicecalendariodeaula.dominio.usecase.event;

import java.time.LocalDateTime;
import java.util.UUID;

public interface EventFactory{
	
	UUID eventId = UUID.randomUUID();
	
	LocalDateTime dataHoraEvento = LocalDateTime.now();
	
	Object getObject();
	
	String getTipoEvento();
	
	void setObject(Object object);
	
}
