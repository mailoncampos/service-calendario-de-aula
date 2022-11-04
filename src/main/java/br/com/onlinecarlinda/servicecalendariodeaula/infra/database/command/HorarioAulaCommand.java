package br.com.onlinecarlinda.servicecalendariodeaula.infra.database.command;

import java.io.Serializable;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.HorarioAula;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(schema = "dominio", name = "horario_aula")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HorarioAulaCommand implements Serializable{
	
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
	
	@NonNull
	@Column(name = "modelo_horario_semanal")
	private Long modeloHorarioSemanal;
	

	public HorarioAulaCommand(@NonNull LocalTime horaInicio, @NonNull LocalTime horaFim,
			@NonNull String diaSemana) {
		super();
		this.horaInicio = horaInicio;
		this.horaFim = horaFim;
		this.diaSemana = diaSemana;
	}
	
	public HorarioAulaCommand criar(HorarioAula horario) {
		return new HorarioAulaCommand(horario.getHoraInicio(), horario.getHoraFim(), horario.getDiaSemana());
	}
	
	public HorarioAula criarHorarioAula() {
		return new HorarioAula(id ,horaInicio, horaFim, diaSemana, modeloHorarioSemanal);
	}
	
}
