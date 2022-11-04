package br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.vo;

public class CPF {
	
	private String cpf;
	
	public CPF() {
	}
	
	public String validar(String cpf) throws Exception {
		
		if(!cpf.matches("(^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$)")) {
			throw new Exception("Formato do CPF incorreto. Ex: 999.999.999-99");
		}
		
		this.cpf = cpf.replaceAll("\\.", "");
		
		return this.cpf;
	}

}
