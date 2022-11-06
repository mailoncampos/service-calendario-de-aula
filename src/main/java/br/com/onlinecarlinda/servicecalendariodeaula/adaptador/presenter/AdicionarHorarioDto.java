package br.com.onlinecarlinda.servicecalendariodeaula.adaptador.presenter;

import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.horario.Horario;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class AdicionarHorarioDto {
	
	@JsonFormat(pattern = "hh:MM")
	private LocalTime horaInicio;
	
	@JsonFormat(pattern = "hh:MM")
	private LocalTime horaConclusao;
	
	private String dia;
	
	private String modeloHorario;
	
	public Horario criarHorario() {
		return new Horario().adicionarHorario(horaInicio, horaConclusao, dia, modeloHorario);
	}
	
	public AdicionarHorarioDto parseToHorario(Horario horario) {
		
		this.horaInicio = LocalTime.of(horario.getHoraInicio().getHour(), horario.getHoraInicio().getMinute());
		this.horaConclusao = LocalTime.of(horario.getHoraConclusao().getHour(), horario.getHoraConclusao().getMinute());
		this.dia = horario.getDia().getDescricao();
		this.modeloHorario = horario.getModeloHorario().getNome();
		return this;
	}
	
	
}
