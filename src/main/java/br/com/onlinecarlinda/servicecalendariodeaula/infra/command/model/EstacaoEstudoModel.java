package br.com.onlinecarlinda.servicecalendariodeaula.infra.command.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(schema = "dominio", name = "estacao_estudo")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EstacaoEstudoModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@NonNull
	@Column
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "id_sala")
	private SalaModel sala;

}
