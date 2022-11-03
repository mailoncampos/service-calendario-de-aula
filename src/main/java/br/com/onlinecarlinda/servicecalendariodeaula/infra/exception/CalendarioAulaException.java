package br.com.onlinecarlinda.servicecalendariodeaula.infra.exception;

public class CalendarioAulaException extends Exception{

	private static final long serialVersionUID = 17459397L;
	
	public CalendarioAulaException(String mensagem) {
		super(mensagem);
	}

}
