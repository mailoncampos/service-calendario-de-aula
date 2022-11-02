package br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aluno.vo;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aluno.Aluno;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aula.HorarioAula;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class HorariosAulaAlunoVo {
	
	private HorarioAula horario;
	
	private Aluno aluno;

}
