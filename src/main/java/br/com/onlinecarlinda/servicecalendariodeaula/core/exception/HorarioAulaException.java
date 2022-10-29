package br.com.onlinecarlinda.servicecalendariodeaula.core.exception;

import lombok.Getter;

@Getter
public class HorarioAulaException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private String mensagem;
	
	private Exception e;
	
	public HorarioAulaException(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public HorarioAulaException(String mensagem, Exception e) {
		this.mensagem = mensagem;
		this.e = e;
	}

}
