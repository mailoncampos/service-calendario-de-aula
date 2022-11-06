package br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.estacaoestudo;

import java.util.List;

public interface EstacaoEstudoRepository {
	
	List<EstacaoEstudo> buscarEstacoesEstudoPorIds(List<Long> idEstacoes);

}
