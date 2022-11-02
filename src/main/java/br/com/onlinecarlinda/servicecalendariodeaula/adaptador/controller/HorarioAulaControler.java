package br.com.onlinecarlinda.servicecalendariodeaula.adaptador.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.onlinecarlinda.servicecalendariodeaula.aplicacao.command.CadastroHorarioAula;
import br.com.onlinecarlinda.servicecalendariodeaula.aplicacao.command.dto.CadastrarHorarioAulaDto;

@RestController
@RequestMapping("/horario-aula")
public class HorarioAulaControler {
	
	@Autowired
	private CadastroHorarioAula cadastroHorarioAula;
	
	@PostMapping
	public ResponseEntity<Exception> cadastrar(@RequestBody CadastrarHorarioAulaDto horarioAulaDto) {
		
		try {
			cadastroHorarioAula.executa(horarioAulaDto.criarHorarioAula());	
			return ResponseEntity.status(HttpStatus.CREATED).body(null);
		}catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.OK).body(e);
		}
	}

}
