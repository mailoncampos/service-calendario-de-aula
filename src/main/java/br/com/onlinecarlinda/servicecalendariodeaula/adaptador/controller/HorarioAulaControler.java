package br.com.onlinecarlinda.servicecalendariodeaula.adaptador.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.onlinecarlinda.servicecalendariodeaula.aplicacao.command.CadastroHorarioAula;
import br.com.onlinecarlinda.servicecalendariodeaula.aplicacao.command.dto.CadastrarHorarioAulaDto;
import br.com.onlinecarlinda.servicecalendariodeaula.infra.exception.CalendarioAulaException;

@RestController
@RequestMapping("/horario-aula")
public class HorarioAulaControler {

	@Autowired
	private CadastroHorarioAula cadastroHorarioAula;

	@PostMapping
	public HttpStatus cadastrar(@RequestBody CadastrarHorarioAulaDto horarioAulaDto)
			throws CalendarioAulaException {

//		try {
//			horarioAulaDto.parseHorarioAula(cadastroHorarioAula.executa(horarioAulaDto.criarHorarioAula()));
//			return HttpStatus.CREATED;
//		} catch (CalendarioAulaException e) {
//			e.printStackTrace();
//			return HttpStatus.ALREADY_REPORTED;
//		}
	return null;
	}
	
}
