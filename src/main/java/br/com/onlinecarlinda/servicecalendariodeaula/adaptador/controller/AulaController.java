package br.com.onlinecarlinda.servicecalendariodeaula.adaptador.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.onlinecarlinda.servicecalendariodeaula.aplicacao.command.aula.GerarAulas;
import br.com.onlinecarlinda.servicecalendariodeaula.aplicacao.command.aula.dto.CadastraAulaPorDemandaDto;

@RestController
@RequestMapping("/aula")
public class AulaController {
	
		
	@PostMapping
	public ResponseEntity<String> cadastrar(@RequestBody CadastraAulaPorDemandaDto  cadastraAulaDto) {
		

		
//		cadastraAulaPorDemanda.executa(cadastraAulaDto);
		

			return ResponseEntity.status(HttpStatus.OK).body("foii");
		
		
	}

}
