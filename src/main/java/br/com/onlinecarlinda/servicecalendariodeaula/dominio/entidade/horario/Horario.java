package br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.horario;

import java.time.LocalTime;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.gradehorarios.Dia;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Horario {

	private Long idHorario;

	private LocalTime horaInicio;

	private LocalTime horaConclusao;

	private Dia dia;
	
	public Horario adicionarHorario(LocalTime horaInicio, LocalTime horaConclusao, String dia) {

		if (horaInicio == null || horaConclusao == null || dia == null) {
			throw new IllegalArgumentException("Para adicionar um horário é necessaario preencher todos os campos");
		}

		if (horaInicio.isAfter(horaConclusao)) {
			throw new IllegalArgumentException("Hora de inicio deve ser anterior a hora de conclusão");
		}

		this.horaInicio = horaInicio;
		this.horaConclusao = horaConclusao;
		this.dia = Dia.toEnum(dia);
		return this;
	}

	public void removerHorario(Long idHorario) {
		
	}
}
