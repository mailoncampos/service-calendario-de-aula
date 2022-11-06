package br.com.onlinecarlinda.servicecalendariodeaula.dominio.service.aula;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aluno.Aluno;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aula.AndamentoAula;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aula.Aula;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aula.AulaRepository;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.horario.Dia;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.horario.Horario;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.sala.Sala;

@Service
public class AgendarAulaService {

	@Autowired
	private AulaRepository aulaRepository;

	private List<Horario> horarios = new ArrayList<>();

	private List<Aula> aulas = new ArrayList<>();

	private List<Horario> horariosDoDia = new ArrayList<>();

	private LocalDate data;

	public void agendarAulaPorSala(Sala sala) {

		data = LocalDate.now();

		if (sala.getIdHorarios().isEmpty())
			return;

		listarEOrdenarHorariosSala(sala);

		List<Aula> aulasDoDia = listarAulasPorData(aulas);

		listarHorariosDoDia(Dia.toEnum(data));

		List<Horario> horariosSemAulaAgendada = compararHorariosDoDiaComAulasAgendadas(aulasDoDia);
		
		if(!horariosSemAulaAgendada.isEmpty())
			horariosSemAulaAgendada.stream().forEach((horario) -> {
				agendarAula(horario, data, sala);
			});
	}
	
	public void agendarAula(Horario horario, LocalDate data, Sala sala) {
		
		List<Aluno> alunos = new ArrayList<>();
		
		Aula aula = new Aula().agendarAula(horario, data, sala, alunos);
		
		aulaRepository.adicionarOuModificarAula(aula);
	}

	private List<Aula> listarAulasPorData(List<Aula> aulas) {

		List<Aula> aulasDoDia = new ArrayList<>();
		for (Aula aula : aulas) {
			if (aula.getData().isEqual(data))
				aulasDoDia.add(aula);
		}
		return aulasDoDia;

	}

	private void listarHorariosDoDia(Dia dia) {

		for (Horario horario : this.horarios) {
			if (dia.equals(horario.getDia()))
				horariosDoDia.add(horario);
		}

		if (horariosDoDia.isEmpty())
			return;
	}

	private List<Horario> compararHorariosDoDiaComAulasAgendadas(List<Aula> aulasDoDia) {

		List<Horario> horariosComAulas = new ArrayList<>();
		List<Horario> horariosSemAulas = new ArrayList<>();

		for (Horario horario : this.horariosDoDia) {
			for (Aula aula : aulasDoDia) {
				if (aula.getIdHorario().equals(horario.getIdHorario())) {
					horariosComAulas.add(horario);
					break;
				}

			}
		}

		if (horariosComAulas.size() == this.horariosDoDia.size())
			return horariosSemAulas;

		for (Horario horario : this.horariosDoDia) {
			boolean flag = true;
			for (Horario horarioComAula : horariosComAulas) {
				if (horario.getIdHorario().equals(horarioComAula.getIdHorario())) {
					flag = false;
					break;
				}
			}

			if (flag == true)
				horariosSemAulas.add(horario);
		}
		return horariosSemAulas;
	}

	private void listarEOrdenarHorariosSala(Sala sala) {

		this.aulas = aulaRepository.buscarAulasPorAndamentoESala(AndamentoAula.AGENDADA.toString(), sala.getIdSala());

		aulas.forEach((aula) -> {
			horarios.add(new Horario(aula.getIdHorario(), aula.getHoraInicio(), aula.getHoraConclusao(), aula.getDia(),
					null));
		});

	}

}
