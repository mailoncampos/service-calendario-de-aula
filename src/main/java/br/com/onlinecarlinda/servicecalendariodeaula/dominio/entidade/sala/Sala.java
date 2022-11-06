package br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.sala;

import java.util.ArrayList;
import java.util.List;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.estacaoestudo.EstacaoEstudoId;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Sala {

	private Long idSala;

	private String nome;

	private GradeHorariosSala gradeHorarioSemanal;

	private List<EstacaoEstudoId> estacoesEstudo = new ArrayList<>();

	public Sala cadastrarSala(String nome, List<EstacaoEstudoId> estacoesEstudo,
			GradeHorariosSala gradeHorarioSemanal) {

		if (gradeHorarioSemanal != null && gradeHorarioSemanal.getIdGradeHorarario() != null
				&& gradeHorarioSemanal.getIdGradeHorarario().getNomeGradeHorario() != null)
			this.gradeHorarioSemanal = gradeHorarioSemanal;
		
		if (estacoesEstudo != null && !estacoesEstudo.isEmpty())
			this.estacoesEstudo = estacoesEstudo;
		
		
		this.nome = validarNome(nome);
		return this;
	}

	public Sala adicionarEstacao(EstacaoEstudoId estacãoEstudo) {

		if (estacãoEstudo == null || estacãoEstudo.getIdEstacao() == null)
			throw new IllegalArgumentException("É necessario informar o id da estação de estudo");

		this.estacoesEstudo.add(estacãoEstudo);
		return this;
	}

	public void alterarNome(String nome) {
		this.nome = validarNome(nome);
	}

	public void removerEstacao(Long idEstacaoEstudo) {

	}

	private String validarNome(String nome) {

		if (nome == null)
			throw new IllegalArgumentException("Nome da sala não pode ser nulo");

		if (nome.length() > 20)
			throw new IllegalArgumentException("Nome da sala não pode conter mais de 20 caracteres");
		return nome;
	}

}
