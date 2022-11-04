package br.com.onlinecarlinda.servicecalendariodeaula.dominio.usecase;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.HorarioAula;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.SalaAula;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aula.Aula;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aula.enuns.DiaSemana;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aula.enuns.SituacaoAula;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.repository.AulaRepository;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.repository.HorarioAulaRepository;

@Component
@EnableScheduling
public class GerarAulasProximosDias {

	private final Long diasNoFuturo = 5L;

	private final String CRON = "*/30 * * * * *";

	@Autowired
	private AulaRepository aulaRepository;

	@Autowired
	private HorarioAulaRepository horarioAulaRepository;

	@Scheduled(cron = CRON)
	public void gerar() {
		executar();
	}

	public void executar() {

		Long modeloHorario = 0L;
		List<LocalDate> diasSemAula = listarDiasSemAula();

		if (diasSemAula.isEmpty()) {
			return;
		}

		for (LocalDate auxDate : diasSemAula) {
			

			/*
			 * Verificar se a data não é um feriado
			 */
			SalaAula salaAula = new SalaAula(1L);
			List<Aula> aulas = new ArrayList<Aula>();

			List<HorarioAula> horariosAulaDoDia = horarioAulaRepository
					.buscarHorariosAulaPorDiaSemanaEModelo(DiaSemana.toEnum(auxDate).toString(), modeloHorario);

			for (HorarioAula auxHorarioAula : horariosAulaDoDia) {
				//				/*
//				 * Buscar os alunos com aula marcada nesse horario
//				 * 
//				 * Buscar as estaçoes de aulas cadastradas no sistema
//				 * 
//				 */
				aulas.add(new Aula().agendarAula(auxHorarioAula, SituacaoAula.AGENDADA, auxDate, salaAula));

			}

			aulaRepository.agendarAulas(aulas);

		}

	}

	private List<LocalDate> listarDiasSemAula() {

		Long diasNoFuturoLocal = diasNoFuturo;

		LocalDate dataAtual = LocalDate.now();

		LocalDate dataFutura = dataAtual.plusDays(diasNoFuturoLocal);

		List<LocalDate> listaDeDataSemAula = new ArrayList<LocalDate>();

		List<Aula> aulasDoDia = aulaRepository.buscarAulasPorData(dataFutura);
		while (aulasDoDia.isEmpty() && diasNoFuturoLocal != 0L) {

			listaDeDataSemAula.add(dataFutura);

			diasNoFuturoLocal--;
			dataFutura = dataAtual.plusDays(diasNoFuturoLocal);

			aulasDoDia = aulaRepository.buscarAulasPorData(dataFutura);
		}

		listaDeDataSemAula.sort((a, b) -> a.compareTo(b));

		return listaDeDataSemAula;
	}

}
