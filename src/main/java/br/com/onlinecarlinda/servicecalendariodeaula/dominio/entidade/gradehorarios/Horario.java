package br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.gradehorarios;

import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

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

//	public Horario criar(LocalTime horaInicio, LocalTime horaFim, String diaSemana, Long modeloHorarioSemanal) {
//				
//		DiaSemana diaSemanaEnum = DiaSemana.valueOf(diaSemana);
//		
//		if(DiaSemana.DOMINGO.equals(diaSemanaEnum)) {
//			throw new IllegalArgumentException("Não é permitido cadastrar um horário de aula no " + diaSemanaEnum.getDescricao());
//		}
//		
//		if(horaInicio.isAfter(horaFim)) {
//			throw new IllegalArgumentException("Hora de final deve ser posterior a hora inicial");
//		}
//		
//		this.horaInicio = horaInicio;
//		this.horaFim = horaFim;
//		this.diaSemana = diaSemana.toString();
//		
//		return this;
//	}

	public Horario parseObject(Object object) {

		Horario horarioAula = (Horario) object;
		return horarioAula;
	}

	public Horario criar(Long id, @NonNull LocalTime horaInicio, @NonNull LocalTime horaConclusao,
			@NonNull String dia, @NonNull String nomeModelo, @NonNull String estadoModelo) {
		
		this.idHorario = id;
		this.horaInicio = horaInicio;
		this.horaConclusao = horaConclusao;
		this.dia = Dia.valueOf(dia);
		return this;
	}



}
