package br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.horario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ModeloHorario {
	
	private String nome;
	
	private EstadoModelo estadoModelo;
	
	public ModeloHorario(String nome) {
		this.nome = nome;
	}
	
}
