package br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aula.enuns;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public enum DiaSemana {
	
	DOMINGO(0L,"Domingo"),
	SEGUNDA(1L,"Segunda-feira"),
	TERCA(2L,"Terça-feira"),
	QUARTA(3L,"Quarta-feira"),
	QUINTA(4L,"Quinta-feira"),
	SEXTA(5L,"Sexta-feira"),
	SABADO(6L, "Sabádo");
	
	private String descricao;

	private Long numero;

	DiaSemana(String descricao) {
		
	}
	
	DiaSemana(Long numero) {
		
	}
	
	DiaSemana(Long numero, String descricao) {
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
	public static DiaSemana toEnum(LocalDate data) {
		
		List<Long> dias = new ArrayList<>();
		
		return DiaSemana.SABADO;
		
//		for(Long dia : DiaSemana.values()) {
//			
//			if(dia.equals((long)data.getDayOfWeek().getValue())) {
//				return dia;
//			}
//		}
//		
//		throw new RuntimeException("Data invalida");

	}

	private DiaSemana(String descricao, Long numero) {
		this.descricao = descricao;
		this.numero = numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}
	
	

}
