package br.com.onlinecarlinda.servicecalendariodeaula.aplicacao.command.aula;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.service.aula.AulaService;

@Component
@EnableScheduling
public class AgendarAula {
	
	private final String CRON = "*/30 * * * * *";
	
	@Autowired
	private AulaService aulaService;

	@Scheduled(cron = CRON)
	public void gerar() {
		aulaService.agendarAula();
	}
	
}
