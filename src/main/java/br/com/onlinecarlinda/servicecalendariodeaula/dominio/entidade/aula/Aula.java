package br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aula;

import java.time.LocalDate;
import java.util.List;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aluno.Aluno;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aula.enuns.AndamentoAula;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.estacaoestudo.EstacaoEstudoId;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.horario.Horario;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.professor.ProfessorId;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.sala.Sala;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.sala.SalaId;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Aula {

	private Long idAula;

	private LocalDate data;
	
	private HorarioAula horario;

	private AndamentoAula andamento;

	private SalaId idSala;

	private List<AlunoAula> alunos;
	
	private List<EstacaoEstudoId> estacoesEstudo;

	private ProfessorId idProfessor;


	public Aula agendarAula(Horario horario, LocalDate data, Sala sala, List<Aluno> alunos) {

		if (horario == null || horario.getHoraInicio() == null || horario.getHoraConclusao() == null
				|| horario.getDia() == null || data == null || sala == null || sala.getIdSala() == null) {
			throw new IllegalArgumentException("Falta informação para efetuar o agendamento");
		}
		
		if(data.isBefore(LocalDate.now()))
			throw new IllegalArgumentException("Data do agendamento não pode ser anterior a data atual");

			
//		if(alunos != null && !alunos.isEmpty())
//			alunos.stream().forEach((aluno) -> {
//				this.cpfAlunos.add(aluno.getCpf());
//			});
		
		this.data = data;
//		this.idSalaAula = sala.getIdSala();
		this.andamento = AndamentoAula.AGENDADA;

		return this;
	}
	
	public Aula agendarAlunoNaAula(Aula aula, Sala sala ,Aluno aluno) {
		
		return this;
	}
	
	public void registrarFrequencia() {
		
	}
	
	public void cancelarAula() {
		
	}
	
	public void removerEstacaoIndisponivel() {
		
	}

	public void adicionarEstacao() {
		
	}

	public void concluirAula(Long idProfessor) {
		
	}
	
	public void name() {
		
	}
}
