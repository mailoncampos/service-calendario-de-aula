package br.com.onlinecarlinda.servicecalendariodeaula.aplicacao.event;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;

@Getter
public class Evento extends ApplicationEvent{

	private static final long serialVersionUID = 9146246528236621534L;
	
	private PayloadEvento payload;
	
	private Object obj;
	
	public Evento(Object source, PayloadEvento payload) {
		super(source);
		this.payload = payload;
	}
	
	public Evento(Object source, PayloadEvento payload, Object obj) {
		super(source);
		this.obj = obj;
		this.payload = payload;
	}

}
