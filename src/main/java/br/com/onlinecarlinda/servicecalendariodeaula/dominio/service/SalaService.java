package br.com.onlinecarlinda.servicecalendariodeaula.dominio.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.estacaoestudo.EstacaoEstudoId;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.gradehorarios.GradeHorarios;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.sala.GradeHorariosSala;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.sala.Sala;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.sala.SalaRepository;

@Service
public class SalaService {

	@Autowired
	private SalaRepository salaRepository;

	@Autowired
	private GradeHorarioService gradeHorarioService;
	
	public void cadastarSala(String nome, String nomeGradeHorario ,List<Long> idsEstacoes) {
		
		List<EstacaoEstudoId> estacao = new ArrayList<>();
		GradeHorariosSala gradeSala = new GradeHorariosSala();// gradeHorarioService.buscarGradeHorariosPorNome(nomeGradeHorario);
		Sala sala = new Sala();
		
		if(idsEstacoes != null && !idsEstacoes.isEmpty())
			idsEstacoes.stream().forEach((idEstacao) -> {estacao.add( new EstacaoEstudoId(idEstacao)) ;}); // validar estaçoes

		GradeHorarios grade =  gradeHorarioService.buscarGradeHorariosPorNome(nomeGradeHorario);
		
		List<Long> idsHorario = new ArrayList<>();
		
		if(grade != null) {
			grade.getHorarios().stream().forEach((idHorario) -> { idsHorario.add(idHorario.getIdHorario());});
			gradeSala.cadastrarGradeHorariosJuntoASala(grade.getNome(),idsHorario);
		}
		
		sala.cadastrarSala(nome, estacao, gradeSala);
		salaRepository.adicionarOuModificarSala(sala);
	}
	
	public List<Sala> buscarTodas(){
		return salaRepository.buscarTodas();
	}

}
