package br.com.onlinecarlinda.servicecalendariodeaula.adaptador.presenter;

import java.util.ArrayList;
import java.util.List;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.horario.Horario;
import lombok.Getter;

@Getter
public class CriarGradeHorarioDto {
	
	private String nomeGradeHorario;
	
	private List<HorarioDto> horariosDto = new ArrayList<>();
	
	public List<Horario> getHorarios() {
		
		List<Horario> horarios = new ArrayList<>();
		
		if(this.horariosDto != null)
			this.horariosDto.stream().forEach((horarioDto) -> {
				horarios.add(new Horario().adicionarHorario(horarioDto.getHoraInicio(), horarioDto.getHoraConclusao(),
						horarioDto.getDia()));
			});
		return horarios;
	}

}
