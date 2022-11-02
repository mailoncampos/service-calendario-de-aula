package br.com.onlinecarlinda.servicecalendariodeaula.infra.database.mogodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import br.com.onlinecarlinda.servicecalendariodeaula.aplicacao.event.HorarioAulaCadastradoEvent;
import br.com.onlinecarlinda.servicecalendariodeaula.infra.database.mogodb.model.HorarioAulaRead;

@Component
public class HorarioAulaListener {
	
	@Autowired
	private HorarioAulaJpaRead horarioAulaJpaRead;
	
	@EventListener
	void horarioAulaCadastrado(HorarioAulaCadastradoEvent horarioAulaCadastradoEvent) {
		horarioAulaJpaRead.save(new HorarioAulaRead().criarHorarioAulaRead(horarioAulaCadastradoEvent));
	}

}
