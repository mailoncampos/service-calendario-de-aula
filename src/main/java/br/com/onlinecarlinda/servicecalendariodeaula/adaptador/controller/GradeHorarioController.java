package br.com.onlinecarlinda.servicecalendariodeaula.adaptador.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.onlinecarlinda.servicecalendariodeaula.adaptador.presenter.CriarGradeHorarioDto;
import br.com.onlinecarlinda.servicecalendariodeaula.aplicacao.command.gradehorario.CriarGradeHorarioCommand;
import br.com.onlinecarlinda.servicecalendariodeaula.infra.exception.CalendarioAulaException;

@RestController
@RequestMapping("/horario-aula")
public class GradeHorarioController {

	@Autowired
	private CriarGradeHorarioCommand criarGradeHorarioCommand;

	@PostMapping
	public HttpStatus criarGradeHorarios(@RequestBody CriarGradeHorarioDto gradeHorarioDto) throws CalendarioAulaException {

		return criarGradeHorarioCommand.executa(gradeHorarioDto.getNomeGradeHorario(), gradeHorarioDto.getHorarios());
	}

}
