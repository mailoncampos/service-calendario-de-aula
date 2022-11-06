package br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.gradehorarios;

import java.time.LocalDate;

import lombok.Getter;

@Getter
public enum Dia {
	
	DOMINGO(0L,"Domingo"),
	SEGUNDA(1L,"Segunda-feira"),
	TERCA(2L,"Terça-feira"),
	QUARTA(3L,"Quarta-feira"),
	QUINTA(4L,"Quinta-feira"),
	SEXTA(5L,"Sexta-feira"),
	SABADO(6L, "Sabádo");
	
	private final String descricao;

	private final Long numero;

	Dia(Long numero, String descricao) {
		this.descricao = descricao;
		this.numero = numero;
	}
	
	public static Dia toEnum(String descricao) {
		
		if(descricao == null) {
			throw new IllegalArgumentException("A descrição não pode ser nula");
		}
		
		for(Dia aux : Dia.values()) {
			if(Dia.valueOf(aux.toString()).getDescricao().equals(descricao)) {
				return aux;
			}
		}
		throw new IllegalArgumentException("A descrição não corresponde com a descrição existente no sistema");
	}
	
	
	public static Dia toEnum(LocalDate data) {
		
//		List<Long> dias = new ArrayList<>();
		
		return Dia.SABADO;
		
//		for(Long dia : DiaSemana.values()) {
//			
//			if(dia.equals((long)data.getDayOfWeek().getValue())) {
//				return dia;
//			}
//		}
//		
//		throw new RuntimeException("Data invalida");

	}	

}
