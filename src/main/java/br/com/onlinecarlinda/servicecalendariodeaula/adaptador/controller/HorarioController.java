package br.com.onlinecarlinda.servicecalendariodeaula.adaptador.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.onlinecarlinda.servicecalendariodeaula.adaptador.presenter.AdicionarHorarioDto;
import br.com.onlinecarlinda.servicecalendariodeaula.aplicacao.command.horario.AdicionarHorarioCommand;
import br.com.onlinecarlinda.servicecalendariodeaula.infra.exception.CalendarioAulaException;

@RestController
@RequestMapping("/horario-aula")
public class HorarioController {

	@Autowired
	private AdicionarHorarioCommand adicionarHorario;

	@PostMapping
	public HttpStatus cadastrar(@RequestBody AdicionarHorarioDto horarioDto) throws CalendarioAulaException {

		return adicionarHorario.executa(horarioDto.criarHorario());

	}

}
