package br.com.onlinecarlinda.servicecalendariodeaula.infra.database.mogodb.model;

import java.time.LocalTime;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import br.com.onlinecarlinda.servicecalendariodeaula.aplicacao.event.HorarioAulaCadastradoEvent;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aula.vo.HorarioAula;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class HorarioAulaRead {
	
	@Id
	private String idMongoDB;
	
	private Long id;

	private LocalTime horaInicio;
	
	private LocalTime horaFim;
	
	private String diaSemana;
	
	private String tipoEvento;
	
	public HorarioAula criarHorarioAula() {
		return new HorarioAula(id ,horaInicio, horaFim, diaSemana);
	}
	
	public HorarioAulaRead criarHorarioAulaRead(HorarioAulaCadastradoEvent horarioAulaEvent) {
		this.id = horarioAulaEvent.getIdHorarioAula();
		this.horaInicio =  horarioAulaEvent.getHoraInicio();
		this.horaFim =  horarioAulaEvent.getHoraFim();
		this.diaSemana =  horarioAulaEvent.getDiaSemana();
		this.tipoEvento =  horarioAulaEvent.getTipoEvento().toString();
		return this;
	}

}
