package br.com.onlinecarlinda.servicecalendariodeaula.adaptador.presenter;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CadastrarSalaDto {

	private String nomeSala;

	private String nomeGradeHorario;

	private List<Long> idEstacoes = new ArrayList<Long>();

}
