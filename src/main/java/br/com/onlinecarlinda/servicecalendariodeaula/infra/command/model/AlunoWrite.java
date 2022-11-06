package br.com.onlinecarlinda.servicecalendariodeaula.infra.command.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Entity
@Table(schema = "dominio", name = "aluno")
@AllArgsConstructor
@Getter
public class AlunoWrite implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_aluno")
	private Long idAluno;
	
	@Column
	private String nome;

	@Column(name = "data_nascimento")
	private LocalDate dataNascimento;

	@Column
	private String cpf;

}
