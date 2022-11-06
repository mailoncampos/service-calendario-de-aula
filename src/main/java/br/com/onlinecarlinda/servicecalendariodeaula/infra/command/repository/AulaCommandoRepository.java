package br.com.onlinecarlinda.servicecalendariodeaula.infra.command.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aula.Aula;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aula.AulaRepository;
import br.com.onlinecarlinda.servicecalendariodeaula.infra.command.model.AulaModel;

@Repository
public interface AulaCommandoRepository extends JpaRepository<AulaModel, Long>, AulaRepository {

	@Query("SELECT a FROM AulaWrite a WHERE a.dataAula = :data")
	List<AulaModel> buscarAulasPorDataQuery(LocalDate data);
	
	@Override
	default void adicionarOuModificarAula(Aula aula) {
		save(null);
	}
	
	@Override
	default List<Aula> buscarAulasPorAndamentoESala(String andamento, Long idSala) {
		// TODO Auto-generated method stub
		return null;
	}

	@Query("SELECT a FROM AulaModel a WHERE a.andamento LIKE :andamento AND a.id = :idSalaO")
	List<Aula> buscarAulasModelPorAndamentoESala(String andamento, Long idSala);
	
}
