package br.com.onlinecarlinda.servicecalendariodeaula.dominio.horarioaula.enuns;

public enum DiaSemanaEnum {
	
	DOMINGO("Domingo"),
	SEGUNDA("Segunda-feira"),
	TERCA("Terça-feira"),
	QUARTA("Quarta-feira"),
	QUINTA("Quinta-feira"),
	SEXTA("Sexta-feira"),
	SABADO("Sabádo");
	
	private String descricao;

	DiaSemanaEnum(String descricao) {
		
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}
