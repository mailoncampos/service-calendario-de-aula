package br.com.onlinecarlinda.servicecalendariodeaula.aplicacao.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class PublicadorEvento implements ApplicationEventPublisherAware{
	
	@Autowired
	private ApplicationEventPublisher publisher;

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.publisher = applicationEventPublisher;		
	}
	
	public void publish(Evento evento) {
	    this.publisher.publishEvent(evento);
	 }

}
