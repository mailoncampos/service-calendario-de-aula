package br.com.onlinecarlinda.servicecalendariodeaula.dominio.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aula.vo.HorarioAula;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.repository.command.HorarioAulaCommandRepository;
import br.com.onlinecarlinda.servicecalendariodeaula.infra.exception.CalendarioAulaException;

@Component
public class HorarioAulaUserCase {
	
	@Autowired
	private HorarioAulaCommandRepository horarioAulaWrite;		
		
	public HorarioAula cadastrar(HorarioAula horarioAula) throws CalendarioAulaException{
		return horarioAulaWrite.cadastrar(horarioAula);
	}

}
