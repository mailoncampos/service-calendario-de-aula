package br.com.onlinecarlinda.servicecalendariodeaula.infra.command.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.sala.Sala;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(schema = "dominio", name = "sala")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SalaModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@NonNull
	@Column
	private String nome;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "id")
	private List<EstacaoEstudoModel> estacoesEstudo = new ArrayList<>();

	@ManyToMany
	@JoinTable(schema = "dominio", name = "horarios_sala", 
	joinColumns = { 
			@JoinColumn(name = "id_sala")
			},
	inverseJoinColumns = {
			@JoinColumn(name = "id_horario") 
			})
	private List<HorarioModel> horarios = new ArrayList<>();

	public SalaModel cadastrarSala(Sala sala) {

		this.nome = sala.getNome();
		
	
		return this;
	}
	
	public SalaModel setId(Long id) {
		this.id = id;
		return this;
	}
	


}
