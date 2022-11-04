package br.com.onlinecarlinda.servicecalendariodeaula.infra.database.query;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AulaQueryRepositoryImpl extends MongoRepository<AulaQuery, String>{
	
	
	
	@Query("SELECT a FROM AulaQuery a WHERE a.dataAula = :data")
	List<AulaQuery> buscarAulasQueryPorData(LocalDate data);
}
