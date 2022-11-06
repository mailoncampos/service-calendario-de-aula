package br.com.onlinecarlinda.servicecalendariodeaula.infra.command.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.estacaoestudo.EstacaoEstudo;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.estacaoestudo.EstacaoEstudoRepository;
import br.com.onlinecarlinda.servicecalendariodeaula.infra.command.model.EstacaoEstudoModel;

@Repository
public interface EstacaoEstudoCommandRepository
		extends JpaRepository<EstacaoEstudoModel, Long>, EstacaoEstudoRepository {

	@Override
	default List<EstacaoEstudo> buscarEstacoesEstudoPorIds(List<Long> idEstacoes) {
		// TODO Auto-generated method stub
		return null;
	}
}
