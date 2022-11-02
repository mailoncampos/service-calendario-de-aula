package br.com.onlinecarlinda.servicecalendariodeaula.adaptador;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.onlinecarlinda.servicecalendariodeaula.adaptador.gateway.RepositoryGatewayFactory;
import br.com.onlinecarlinda.servicecalendariodeaula.aplicacao.command.aula.GerarAulas;

@Component
@EnableScheduling
public class GeraCalendarioAula {
	
	private final String CRON = "*/30 * * * * *";
	
	private GerarAulas gerarAulas;
	
	private RepositoryGatewayFactory repositoryGatewayFactory;
	
	@Scheduled(cron = CRON)
	private void observerScheduling() {
		
		gerarAulas = new GerarAulas(repositoryGatewayFactory.getCommand().getAulaCommandRepository(), repositoryGatewayFactory.getQuery().getAulaQueryRepository());
		
		gerarAulas.executar();
	}

}
