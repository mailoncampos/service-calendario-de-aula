package br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aula;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aluno.Aluno;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.horario.Dia;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.horario.Horario;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.sala.Sala;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.vo.CPF;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Aula {

	private Long idAula;

	private LocalDate data;

	private LocalTime horaInicio;

	private LocalTime horaConclusao;

	private Dia dia;

	private Long idSalaAula;

	private Long idHorario;

	private List<CPF> cpfAlunos;

	private Long idProfessor;

	private AndamentoAula andamento;

	public Aula agendarAula(Horario horario, LocalDate data, Sala sala, List<Aluno> alunos) {

		if (horario == null || horario.getHoraInicio() == null || horario.getHoraConclusao() == null
				|| horario.getDia() == null || data == null || sala == null || sala.getIdSala() == null) {
			throw new IllegalArgumentException("Falta informação para efetuar o agendamento");
		}
		
		if(data.isBefore(LocalDate.now()))
			throw new IllegalArgumentException("Data do agendamento não pode ser anterior a data atual");

			
		if(alunos != null && !alunos.isEmpty())
			alunos.stream().forEach((aluno) -> {
				this.cpfAlunos.add(aluno.getCpf());
			});
		
		this.data = data;
		this.idHorario = horario.getIdHorario();
		this.horaInicio = horario.getHoraInicio();
		this.horaConclusao = horario.getHoraConclusao();
		this.dia = horario.getDia();
		this.idSalaAula = sala.getIdSala();
		this.andamento = AndamentoAula.AGENDADA;

		return this;
	}
	
	public Aula agendarAluno(Aula aula, Sala sala ,Aluno aluno) {
		
		return this;
	}

}
