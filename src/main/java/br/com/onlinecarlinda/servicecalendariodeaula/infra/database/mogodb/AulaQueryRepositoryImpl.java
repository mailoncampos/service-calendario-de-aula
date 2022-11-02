package br.com.onlinecarlinda.servicecalendariodeaula.infra.database.mogodb;

import br.com.onlinecarlinda.servicecalendariodeaula.adaptador.gateway.QueryRepository;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.repository.AulaQueryRepository;

public interface AulaQueryRepositoryImpl extends AulaQueryRepository, QueryRepository{
	
	@Override
	default AulaQueryRepository getAulaQueryRepository() {
		// TODO Auto-generated method stub
		return this;
	}

}
