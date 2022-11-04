package br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aula;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.HorarioAula;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.SalaAula;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aula.enuns.SituacaoAula;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Aula {

	private Long idAula;

	private LocalDate dataAula;

	private LocalTime horaInicio;

	private LocalTime horaFim;

	private String diaSemana;

	private Long idSalaAula;

	private List<Long> idEstacoesDeEstudo;

	private List<Long> idAlunos;

	private Long idProfessor;

	private SituacaoAula situacaoAula;

	public Aula agendarAula(HorarioAula horarioAula, SituacaoAula situacaoAula, LocalDate data, SalaAula salaAula) {

		if (!situacaoAula.equals(SituacaoAula.AGENDADA)) {
			throw new IllegalArgumentException("Situação da aula informada é diferente de agendada");
		}

		this.situacaoAula = situacaoAula;
		return this.validarDataAula(data).validarHorarioAula(horarioAula).validarSadaDeAula(salaAula);
	}

	private Aula validarSadaDeAula(SalaAula salaAula) {
		if (salaAula.getIdSalaAula() == null) {
			throw new IllegalArgumentException("Deve informar uma sala para agendar uma aula");
		}
		return this;
	}

	private Aula validarDataAula(LocalDate data) {
		if (dataAula.isBefore(LocalDate.now())) {
			throw new IllegalArgumentException("A data informada deve ser posterior a de inicio dos cadastros: "
					+ dataAula.format(DateTimeFormatter.ofPattern("dd / MM / yyyy")));
		}
		this.dataAula = data;
		return this;
	}

	private Aula validarHorarioAula(HorarioAula horarioAula) {

		if (horarioAula == null || horarioAula.getDiaSemana() == null || horarioAula.getHoraFim() == null
				|| horarioAula.getHoraInicio() == null || horarioAula.getIdHorarioAula() == null) {
			throw new IllegalArgumentException("Horário de aula invalido");
		}

		this.horaInicio = horarioAula.getHoraInicio();
		this.horaFim = horarioAula.getHoraFim();
		this.diaSemana = horarioAula.getDiaSemana();

		return this;
	}

}
