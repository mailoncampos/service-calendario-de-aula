package br.com.onlinecarlinda.servicecalendariodeaula.infra.database.postgres.model;

import java.io.Serializable;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aula.HorarioAulaFactory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Entity
@Table(schema = "dominio", name = "horario_aula")
@Getter
@AllArgsConstructor
public class HorarioAulaModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@NonNull
	@Column(name = "hora_inicio")
	private LocalTime horaInicio;
	
	@NonNull
	@Column(name = "hora_fim")
	private LocalTime horaFim;
	
	@NonNull
	@Column(name = "dia_semana")
	private String diaSemana;
	
	public HorarioAulaModel(HorarioAulaFactory horarioAulaFactory) {
		super();
		this.horaInicio = horarioAulaFactory.getHorarioAula().getHoraInicio();
		this.horaFim = horarioAulaFactory.getHorarioAula().getHoraFim();
		this.diaSemana = horarioAulaFactory.getHorarioAula().getDiaSemana();	
	}
	

	public HorarioAulaModel(@NonNull LocalTime horaInicio, @NonNull LocalTime horaFim,
			@NonNull String diaSemana) {
		super();
		this.horaInicio = horaInicio;
		this.horaFim = horaFim;
		this.diaSemana = diaSemana;
	}
	
}
