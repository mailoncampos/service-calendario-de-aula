package br.com.onlinecarlinda.servicecalendariodeaula.infra.command.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.gradehorarios.GradeHorarios;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(schema = "dominio", name = "grade_horario")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GradeHorarioModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column
	private String nome;

	@Transient
	private List<HorarioModel> horarios = new ArrayList<>();

	public GradeHorarioModel criarGradeHorarios(GradeHorarios gradeHorarios) {

		this.nome = gradeHorarios.getNome();

		if (gradeHorarios.getHorarios() != null)
			gradeHorarios.getHorarios().stream().forEach((horario) -> {
				this.horarios.add(new HorarioModel().adicionarHorario(horario));
			});

		return this;
	}

}
