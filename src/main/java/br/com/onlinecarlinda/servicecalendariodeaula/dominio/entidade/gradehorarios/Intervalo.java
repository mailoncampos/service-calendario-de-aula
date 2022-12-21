package br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.gradehorarios;

import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Intervalo {

	private LocalTime duracaoIntervalo;
	
	private LocalTime inicioIntervalo;
}
