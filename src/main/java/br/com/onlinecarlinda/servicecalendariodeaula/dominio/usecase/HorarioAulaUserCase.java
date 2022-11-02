package br.com.onlinecarlinda.servicecalendariodeaula.dominio.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aula.vo.HorarioAula;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.repository.command.HorarioAulaCommandRepository;

@Component
public class HorarioAulaUserCase {
	
	@Autowired
	private HorarioAulaCommandRepository horarioAulaWrite;		
		
	public HorarioAula cadastrar(HorarioAula horarioAula) {
		return horarioAulaWrite.cadastrar(horarioAula);
	}

}
