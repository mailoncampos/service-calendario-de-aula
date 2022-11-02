package br.com.onlinecarlinda.servicecalendariodeaula.infra.database.postgres.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.onlinecarlinda.servicecalendariodeaula.adaptador.gateway.CommandRepository;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.repository.AulaCommandRepository;
import br.com.onlinecarlinda.servicecalendariodeaula.infra.database.postgres.model.AulaModel;

@Repository
public interface AulaCommandRepositoryImpl extends JpaRepository<AulaModel, Long>, CommandRepository, AulaCommandRepository{
	
	@Override
	default AulaCommandRepository getAulaCommandRepository() {
		return this;
	}
	
	@Query("SELECT a FROM AulaModel a WHERE a.dataAula = :data")
	List<AulaModel> buscarAulasPorDataQuery(LocalDate data);

}
