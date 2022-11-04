package br.com.onlinecarlinda.servicecalendariodeaula.infra.database.command;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aula.Aula;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.repository.AulaRepository;

@Repository
public interface AulaJpaWrite extends JpaRepository<AulaWrite, Long>, AulaRepository {

	@Query("SELECT a FROM AulaWrite a WHERE a.dataAula = :data")
	List<AulaWrite> buscarAulasPorDataQuery(LocalDate data);

	@Override
	default List<Aula> buscarAulasPorData(LocalDate data) {

		List<Aula> aulas = new ArrayList<>();

		List<AulaWrite> aulasData = buscarAulasPorDataQuery(data);

		for (AulaWrite auxAula : aulasData) {
			aulas.add(auxAula.criarAula());
		}

		return aulas;
	}

	@Override
	default void agendarAulas(List<Aula> aulasDia) {
		// TODO Auto-generated method stub

	}
}
