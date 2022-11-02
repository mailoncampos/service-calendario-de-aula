package br.com.onlinecarlinda.servicecalendariodeaula.infra.database.postgres.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Entity
@Table(schema = "dominio", name = "aula")
@Getter
@AllArgsConstructor
public class AulaCommand implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@NonNull
	@Column(name = "data_aula")
	private LocalDate dataAula;
	
	@NonNull
	@JoinColumn(name = "id_horario_aula", referencedColumnName = "id")
	private HorarioAulaModel  horarioAulaModel;
	
	
//	@Column(name = "hora_fim")
//	private List<EstacaoEstudoModel>  estacaoEstudos;
	
//	@Column(name = "hora_fim")
//	protected List<Aluno> alunos;
	
	@Column(name = "status_aula")
	protected String statusAula;

}
