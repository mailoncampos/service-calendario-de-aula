package br.com.onlinecarlinda.servicecalendariodeaula.adaptador.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.gradehorarios.Dia;



@RestController
@RequestMapping("/base")
public class DadosBaseSalaDeAula {
	
	@GetMapping( value = "/grade-horario")
	public ResponseEntity<List<String>> diasDaSemana(){
		
		System.out.println("To no calendario");
		
		List<String> diasSemana = new ArrayList<>();
		for(Dia dia : Dia.values()) {
			diasSemana.add(dia.getDescricao());
		}
		return ResponseEntity.status(HttpStatus.OK).body(diasSemana);
	}
}
