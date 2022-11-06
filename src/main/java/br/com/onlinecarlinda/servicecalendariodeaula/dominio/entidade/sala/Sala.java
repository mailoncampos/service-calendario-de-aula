package br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.sala;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Sala {

	private Long idSala;

	private String nome;

	private List<Long> idEstacoes = new ArrayList<>();

	private List<Long> idHorarios = new ArrayList<>();

	public Sala cadastrarSala(String nome, List<Long> idEstacoes, List<Long> idHorarios) {

		if (idEstacoes != null && !idEstacoes.isEmpty())
			this.idEstacoes = idEstacoes;
		else
			this.idEstacoes = new ArrayList<Long>();
		
		if (idHorarios != null && !idHorarios.isEmpty())
			this.idHorarios = idHorarios;
		else
			this.idHorarios = new ArrayList<Long>();
		
		this.nome = validarNome(nome);
		
		return this;

	}

	public Sala adicionarEstacao(Long idEstacao) {

		if (idEstacao == null)
			throw new IllegalArgumentException("É necessario informar o id da estação de estudo");

		this.idEstacoes.add(idEstacao);
		return this;

	}

	public Sala adicionarHorario(Long idHorario) {

		if (idHorario == null)
			throw new IllegalArgumentException("É necessario informar o id do horário");
		
		this.idHorarios.add(idHorario);
		return this;
	}

	private String validarNome(String nome) {

		if (nome == null)
			throw new IllegalArgumentException("Nome da sala não pode ser nulo");

		if (nome.length() > 20)
			throw new IllegalArgumentException("Nome da sala não pode conter mais de 20 caracteres");
		return nome;
	}

}
