package br.com.onlinecarlinda.servicecalendariodeaula.aplicacao.query.dto;

import lombok.Getter;

@Getter
public class AlunoBuscarAulaDto {
	
	private String nome;
	
	private String usuario;
	
	private String status;

	public AlunoBuscarAulaDto() {
		super();
	}

}
