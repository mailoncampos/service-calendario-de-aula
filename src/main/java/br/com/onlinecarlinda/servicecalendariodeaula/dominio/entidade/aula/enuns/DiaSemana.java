package br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aula.enuns;

public enum DiaSemana {
	
	DOMINGO("Domingo"),
	SEGUNDA("Segunda-feira"),
	TERCA("Terça-feira"),
	QUARTA("Quarta-feira"),
	QUINTA("Quinta-feira"),
	SEXTA("Sexta-feira"),
	SABADO("Sabádo");
	
	private String descricao;

	DiaSemana(String descricao) {
		
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}
