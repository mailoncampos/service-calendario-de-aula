package br.com.onlinecarlinda.servicecalendariodeaula.adaptador.presenter;

import java.util.ArrayList;
import java.util.List;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.sala.Sala;
import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
public class CadastrarSalaDto {
	
	private String nome;

	private List<Long> idEstacoes = new ArrayList<>();

	@Getter
	private String modeloHorario;
	
	public Sala parseDtoToSala() {
		return new Sala().cadastrarSala(nome, idEstacoes, null);
	}

}
