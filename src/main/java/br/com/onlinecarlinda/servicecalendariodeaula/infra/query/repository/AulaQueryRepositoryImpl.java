package br.com.onlinecarlinda.servicecalendariodeaula.infra.query.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.onlinecarlinda.servicecalendariodeaula.infra.query.model.AulaQuery;

@Repository
public interface AulaQueryRepositoryImpl extends MongoRepository<AulaQuery, String>{
	
	
	
	@Query("SELECT a FROM AulaQuery a WHERE a.dataAula = :data")
	List<AulaQuery> buscarAulasQueryPorData(LocalDate data);
}
