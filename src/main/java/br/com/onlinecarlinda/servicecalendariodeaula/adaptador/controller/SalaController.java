package br.com.onlinecarlinda.servicecalendariodeaula.adaptador.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.onlinecarlinda.servicecalendariodeaula.adaptador.presenter.CadastrarSalaDto;
import br.com.onlinecarlinda.servicecalendariodeaula.aplicacao.command.sala.CadastrarSalaCommand;

@RestController
@RequestMapping("/sala")
public class SalaController {
	
	@Autowired
	private CadastrarSalaCommand cadastrarSalaCommand;
	
	@PostMapping
	public ResponseEntity<String> cadastrarSala(@RequestBody CadastrarSalaDto cadastrarSalaDto){
		
		cadastrarSalaCommand.executa(cadastrarSalaDto.parseDtoToSala(), cadastrarSalaDto.getModeloHorario());
		
		return ResponseEntity.status(HttpStatus.OK).body("");
	}

}
