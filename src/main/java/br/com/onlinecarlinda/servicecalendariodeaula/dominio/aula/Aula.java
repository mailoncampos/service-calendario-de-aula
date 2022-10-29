package br.com.onlinecarlinda.servicecalendariodeaula.dominio.aula;

import java.time.LocalDate;
import java.util.List;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.aluno.Aluno;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.estacaoestudo.EstacaoEstudo;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.horarioaula.HorarioAula;

public class Aula {

	private LocalDate dataAula;
	
	private HorarioAula horarioAula;
	
	private List<EstacaoEstudo> estacoesDeEstudo;
	
	private List<Aluno> alunos;
	
	private String statusAula;
	
}
