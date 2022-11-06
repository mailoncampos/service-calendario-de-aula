package br.com.onlinecarlinda.servicecalendariodeaula.dominio.service.aula;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.sala.Sala;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.service.SalaService;

@Component
@EnableScheduling
public class AulaService {
	
	@Autowired
	private SalaService salaService;
	
	@Autowired
	private AgendarAulaService agendarAulaService;

	

	public void agendarAula() {

		List<Sala> salas = salaService.buscarTodas();
		
		if(salas != null && !salas.isEmpty())
			salas.stream().forEach((sala) -> {agendarAulaService.agendarAulaPorSala(sala);});
			
		
	}


}
