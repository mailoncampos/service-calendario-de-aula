package br.com.onlinecarlinda.servicecalendariodeaula.adaptador.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.onlinecarlinda.servicecalendariodeaula.aplicacao.command.dto.CadastrarHorarioAulaDto;

@RestController
@RequestMapping("/horario-aula")
public class HorarioAulaRestControler {
	
//	private CadastrarHorarioAula cadastrarHorarioAula;
	
	@PostMapping
	public ResponseEntity<String> cadastrar(@RequestBody CadastrarHorarioAulaDto horarioAulaDto) {
		
//		cadastrarHorarioAula = new CadastrarHorarioAula(horarioAulaRepositoryJpa);
//		
//		try {
//			cadastrarHorarioAula.executa(horarioAulaDto);	
//			return ResponseEntity.status(HttpStatus.CREATED).body(null);
//		}catch (HorarioAulaException e) {
//			return ResponseEntity.status(HttpStatus.OK).body(e);
//		}
		return null;
	}

}
