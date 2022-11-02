package br.com.onlinecarlinda.servicecalendariodeaula.infra.database.mogodb;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aula.Aula;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.repository.query.AulaQueryRepository;
import br.com.onlinecarlinda.servicecalendariodeaula.infra.database.mogodb.model.AulaQuery;

@Repository
public interface AulaQueryRepositoryImpl extends MongoRepository<AulaQuery, String>,AulaQueryRepository{
	
	@Override
	default List<Aula> buscarAulasPorData(LocalDate data) {
		
		List<Aula> aulasDoDia = new ArrayList<>();
		List<AulaQuery> aulasQuery =  buscarAulasQueryPorData(data);
		
		
		
		return aulasDoDia;
	}
	
	@Query("SELECT a FROM AulaQuery a WHERE a.dataAula = :data")
	List<AulaQuery> buscarAulasQueryPorData(LocalDate data);
}
