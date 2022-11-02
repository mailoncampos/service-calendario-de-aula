package br.com.onlinecarlinda.servicecalendariodeaula.infra.database.mogodb.model;

import java.time.LocalDate;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Document
@AllArgsConstructor
@Getter
public class AulaQuery {
	
	@Id
	private Long idMongoDB;
	
	private Long idAula;

	protected LocalDate dataAula;
	
	private String statusAula;

}
