package br.com.onlinecarlinda.servicecalendariodeaula.infra.command.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.onlinecarlinda.servicecalendariodeaula.infra.command.model.EstacaoEstudoModel;

@Repository
public interface EstacaoEstudoCommandRepository extends JpaRepository<EstacaoEstudoModel, Long> {

}
