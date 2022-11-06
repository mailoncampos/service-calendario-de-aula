package br.com.onlinecarlinda.servicecalendariodeaula.infra.command.model;

import java.io.Serializable;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.horario.Horario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(schema = "dominio", name = "horario")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HorarioModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@Column(name = "hora_inicio")
	private LocalTime horaInicio;

	@Column(name = "hora_conclusao")
	private LocalTime horaConclusao;

	@Column
	private String dia;

	@Column(name = "nome_modelo")
	private String nomeModelo;

	@Column(name = "estado_modelo")
	private String estadoModelo;

	public HorarioModel(@NonNull LocalTime horaInicio, @NonNull LocalTime horaConclusao, @NonNull String dia) {
		super();
		this.horaInicio = horaInicio;
		this.horaConclusao = horaConclusao;
		this.dia = dia;
	}

	public HorarioModel adicionarHorario(Horario horario) {
		
		this.horaInicio = horario.getHoraInicio();
		this.horaConclusao = horario.getHoraConclusao();
		this.dia = horario.getDia().toString();
		this.nomeModelo = horario.getModeloHorario().getNome();
		this.estadoModelo = horario.getModeloHorario().getEstadoModelo().toString();
		return this;
	}

	public Horario parseModelToHorario() {
		return new Horario().criar(id, horaInicio, horaConclusao, dia, nomeModelo, estadoModelo);
	}

}
