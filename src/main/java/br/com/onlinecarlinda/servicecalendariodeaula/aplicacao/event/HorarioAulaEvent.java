package br.com.onlinecarlinda.servicecalendariodeaula.aplicacao.event;

import java.util.List;

import org.springframework.context.ApplicationEvent;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.horario.Horario;
import lombok.Getter;

@Getter
public class HorarioAulaEvent extends ApplicationEvent implements EventFactory {

	private static final long serialVersionUID = -2813297669443432918L;

	private Horario horarioAula;

	private TipoEventoHorario tipoEvento;
	
	private String mensagem;

	public HorarioAulaEvent(Object source, List<Horario> horarios, TipoEventoHorario adicionado, String string) {
		super(source);
	}

	public HorarioAulaEvent(Object source ,Horario horarioAula, TipoEventoHorario tipoEvento) {
		super(source);
		this.horarioAula = horarioAula;
		this.tipoEvento = tipoEvento;
	}
	
	public HorarioAulaEvent(Object source ,Horario horarioAula, TipoEventoHorario tipoEvento, String mensagem) {
		super(source);
		this.horarioAula = horarioAula;
		this.tipoEvento = tipoEvento;
		this.mensagem = mensagem;
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
		this.horarioAula = (Horario) object;
	}

}
