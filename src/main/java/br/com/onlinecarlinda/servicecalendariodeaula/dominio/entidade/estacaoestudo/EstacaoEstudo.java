package br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.estacaoestudo;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class EstacaoEstudo {
	
	private Long idEstacao;
	
	private String nomeEstacao;
	
	private DisponibilidadeEstacao disponibilidade;
	
	public void cadastrarEstacao(String nome, String disponibilidade) {
		
		if(nome == null)
			throw new IllegalArgumentException("O nome da estação não pode ser nulo");
		
		if(disponibilidade == null)
			throw new IllegalArgumentException("A disponilibilidade deve ser informada");

		this.nomeEstacao = nome;
		this.disponibilidade = DisponibilidadeEstacao.valueOf(disponibilidade);
		
	}
	
	public void disponilibizarEstacao(String nome){
		this.disponibilidade = DisponibilidadeEstacao.DISPONIVEL;
	}

	public void indisponilibizarEstacao(String nome){
		this.disponibilidade = DisponibilidadeEstacao.INDISPONIVEL;
	}

}
