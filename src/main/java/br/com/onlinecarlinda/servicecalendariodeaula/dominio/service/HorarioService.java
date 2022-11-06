package br.com.onlinecarlinda.servicecalendariodeaula.dominio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.horario.Horario;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.horario.HorarioRepository;

@Service
public class HorarioService {

	@Autowired
	private HorarioRepository horarioRepository;

	public void adicionarHorario(Horario horario) {
		horarioRepository.adicionarOuModificarHorario(horario.adicionarHorario(horario.getHoraInicio(),
				horario.getHoraConclusao(), horario.getDia().getDescricao(), horario.getModeloHorario().getNome()));
	}

	public List<Horario> buscarHorariosPorNomeModeloHorario(String nome) {
		return horarioRepository.buscarHorariosPorNomeModeloHorario(nome);
	}

}

//		try {
//			
//			horarioAulaWrite.adicionarOuModificarHorario(horarioAula);
//			publisher.publishEvent( new HorarioAulaEvent(this, horarioAula, TipoEventoHorarioAula.CADASTRADO));
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}finally {
//			
//		}
//		
//	}
