package br.com.onlinecarlinda.servicecalendariodeaula.dominio.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.estacaoestudo.EstacaoEstudo;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.horario.EstadoModelo;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.horario.Horario;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.sala.Sala;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.sala.SalaRepository;
import br.com.onlinecarlinda.servicecalendariodeaula.infra.exception.CalendarioAulaException;

@Service
public class SalaService {

	@Autowired
	private SalaRepository salaRepository;

	@Autowired
	private HorarioService horarioService;

	@Autowired
	private EstacaoEstudoService estacaoEstudoService;

	public void cadastarSala(Sala sala, String nomeModeloHorario) {

		List<Horario> horarios = new ArrayList<Horario>();
		if (nomeModeloHorario != null) {
			horarios = horarioService.buscarHorariosPorNomeModeloHorario(nomeModeloHorario);
			if(horarios.isEmpty()) {
				throw new CalendarioAulaException("Erro ao carregar os horários referente ao nome do modelo informado");
			}
			horarios.stream().forEach((a) -> {
					if(!a.getModeloHorario().getEstadoModelo().equals(EstadoModelo.DISPONIVEL))
						throw new CalendarioAulaException("Modelo de horario semanal indisponivel");
					sala.getIdHorarios().add(a.getIdHorario()); 
				});
		}

		List<EstacaoEstudo> estacoes = new ArrayList<EstacaoEstudo>();
		if (!sala.getIdEstacoes().isEmpty()) {
			estacoes = estacaoEstudoService.buscarEstacoesEstudoPorIds(sala.getIdEstacoes());
			if (sala.getIdEstacoes().size() != estacoes.size())
				throw new CalendarioAulaException("Erro ao carregar as estações de estudo");
		}

		salaRepository.adicionarOuModificarSala(sala.cadastrarSala(sala.getNome(), sala.getIdEstacoes(), sala.getIdHorarios()));
	}
	
	public List<Sala> buscarTodas(){
		return salaRepository.buscarTodas();
	}

}
