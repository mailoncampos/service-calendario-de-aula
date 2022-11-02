package br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aula;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aluno.Aluno;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aula.enuns.SituacaoAula;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Aula{
	
	private Long idAula;

	protected LocalDate dataAula;
	
	protected HorarioAula horarioAula;
	
	private List<EstacaoEstudo> estacoesDeEstudo;
	
	private List<Aluno> alunos;
	
	private String statusAula;
	
	
	
	public Aula criar(LocalDate dataAula, HorarioAula horarioAula, SituacaoAula statusAula) {
		
		if(dataAula.isBefore(LocalDate.now())) {
			throw new IllegalArgumentException(
					"A data informada deve ser posterior a de inicio dos cadastros: " 
							+ dataAula.format(DateTimeFormatter.ofPattern("dd / MM / yyyy")));
		}
		
		this.dataAula = dataAula;		
		this.horarioAula = horarioAula;
		this.statusAula = statusAula.toString();
		
		return this;
	}
	
	public Aula criar(LocalDate dataAula, HorarioAula horarioAula, List<EstacaoEstudo> estacoesDeEstudo,
			List<Aluno> alunos, String statusAula) {
		
		if(dataAula.isBefore(LocalDate.now())) {
			throw new IllegalArgumentException(
					"A data informada deve ser posterior a de inicio dos cadastros: " 
					+ dataAula.format(DateTimeFormatter.ofPattern("dd / MM / yyyy")));
		}
		
		this.dataAula = dataAula;		
		this.horarioAula = horarioAula;
		this.estacoesDeEstudo = estacoesDeEstudo;
		this.alunos = alunos;
		this.statusAula = statusAula;
		
		return this;
	}
}
