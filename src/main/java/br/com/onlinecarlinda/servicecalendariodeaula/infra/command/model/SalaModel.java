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

		if (sala.getIdEstacoes() != null && !sala.getIdEstacoes().isEmpty())
			sala.getIdEstacoes().stream().forEach((a) -> {
				this.estacoesEstudo.add(new EstacaoEstudoModel(a, null, null));
			});

		if (sala.getIdHorarios() != null && !sala.getIdHorarios().isEmpty())
			sala.getIdHorarios().stream().forEach((a) -> {
				this.horarios.add(new HorarioModel(a, null, null, null, null, null));
			});

		return this;
	}
	
	public Sala parseModelToSala() {
		
		List<Long> idHorarios = new ArrayList<>();
		
		List<Long> idEstacoes = new ArrayList<>();
		
		this.horarios.stream().forEach((horario) -> {idHorarios.add(horario.getId());});
		this.estacoesEstudo.stream().forEach((estacoes) -> {idEstacoes.add(estacoes.getId());});
		
		return new Sala(id, nome, idEstacoes, idHorarios);
	}

}
