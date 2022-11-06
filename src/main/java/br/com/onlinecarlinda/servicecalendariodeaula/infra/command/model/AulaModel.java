package br.com.onlinecarlinda.servicecalendariodeaula.infra.command.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aula.Aula;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Table(schema = "dominio", name = "aula")
@Getter
@AllArgsConstructor
public class AulaModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter
	@Column
	private Long id;

	@NonNull
	@Column(name = "data_aula")
	private LocalDate dataAula;
	
	@ManyToOne
	@JoinColumn(name = "id_horario", referencedColumnName = "id")
	private HorarioModel horarioModel;
	
	@ManyToOne
	@JoinColumn(name = "id_sala")
	private SalaModel salaModel;
	
	@ManyToOne
	@JoinColumn(name = "id_professor")
	protected ProfessorModel professorModel;
	
	@Column(name = "andamento_aula")
	private String andamentoAula;
	
	@ManyToMany
	@JoinTable(schema = "dominio", name = "horarios_sala", 
	joinColumns = { 
			@JoinColumn(name = "id_sala")
			},
	inverseJoinColumns = {
			@JoinColumn(name = "id_horario") 
			})
	private List<HorarioModel> horarios = new ArrayList<>();
	
	public AulaModel agendarAula(Aula aula) {
		
		this.id = aula.getIdAula();
		this.dataAula = aula.getData();
//		this.salaModel = new SalaModel().setId(aula.getIdSalaAula());;
//		this.professorModel = new ProfessorModel().setId(aula.getIdProfessor());;
		
		return this;
	}

}
