package br.com.onlinecarlinda.servicecalendariodeaula.infra.exception;

import lombok.Getter;

@Getter
public class CalendarioAulaException extends RuntimeException{

	private static final long serialVersionUID = 17459397L;
	
	private String mensagem;
	
	private Throwable throwable;
	
	
	public CalendarioAulaException(String mensagem) {
		super(mensagem);
		this.mensagem = mensagem;
	}
	public CalendarioAulaException(String mensagem, Throwable throwable) {
		super(mensagem);
		this.mensagem = mensagem;
		this.throwable = throwable;
	}

}
