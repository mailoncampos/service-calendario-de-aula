package br.com.onlinecarlinda.servicecalendariodeaula.dominio.usecase.event;

import org.springframework.context.ApplicationEvent;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.HorarioAula;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.usecase.event.enuns.TipoEventoHorarioAula;
import lombok.Getter;

@Getter
public class HorarioAulaEvent extends ApplicationEvent implements EventFactory {

	private static final long serialVersionUID = -2813297669443432918L;

	private HorarioAula horarioAula;

	private TipoEventoHorarioAula tipoEvento;

	public HorarioAulaEvent(Object source) {
		super(source);
	}

	public HorarioAulaEvent(Object source ,HorarioAula horarioAula, TipoEventoHorarioAula tipoEvento) {
		super(source);
		this.horarioAula = horarioAula;
		this.tipoEvento = tipoEvento;
	}

	@Override
	public String getTipoEvento() {
		return tipoEvento.toString();
	}

	@Override
	public Object getObject() {
		return horarioAula;
	}

	@Override
	public void setObject(Object object) {
		this.horarioAula = (HorarioAula) object;
	}

}
