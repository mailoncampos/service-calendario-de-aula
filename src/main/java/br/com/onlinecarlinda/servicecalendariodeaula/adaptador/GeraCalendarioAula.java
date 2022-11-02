package br.com.onlinecarlinda.servicecalendariodeaula.adaptador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.onlinecarlinda.servicecalendariodeaula.aplicacao.command.aula.GerarAulas;

@Component
@EnableScheduling
public class GeraCalendarioAula {
	
	private final String CRON = "*/30 * * * * *";
	
	@Autowired
	private GerarAulas gerarAulas;
		
	@Scheduled(cron = CRON)
	private void observerScheduling() {
		
//		gerarAulas.executar();
	}

}
