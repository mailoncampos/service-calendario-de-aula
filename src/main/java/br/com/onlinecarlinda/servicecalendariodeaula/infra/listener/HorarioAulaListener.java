package br.com.onlinecarlinda.servicecalendariodeaula.infra.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import br.com.onlinecarlinda.servicecalendariodeaula.aplicacao.event.HorarioAulaEvent;
import br.com.onlinecarlinda.servicecalendariodeaula.infra.query.model.HorarioAulaRead;
import br.com.onlinecarlinda.servicecalendariodeaula.infra.query.repository.HorarioAulaJpaRead;

@Component
public class HorarioAulaListener {
	
	@Autowired
	private HorarioAulaJpaRead horarioAulaJpaRead;
	
	@EventListener
	void horarioAulaCadastrado(HorarioAulaEvent horarioAulaEvent) {
		horarioAulaJpaRead.save(new HorarioAulaRead().criarHorarioAulaRead(horarioAulaEvent));
	}

}
