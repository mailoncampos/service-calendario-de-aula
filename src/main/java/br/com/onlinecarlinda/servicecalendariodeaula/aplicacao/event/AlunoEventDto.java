package br.com.onlinecarlinda.servicecalendariodeaula.aplicacao.event;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import br.com.onlinecarlinda.servicecalendariodeaula.aplicacao.command.TipoEventoAluno;
import lombok.Data;

@Data
public class AlunoEventDto {
	
	private UUID eventId;
	
	private LocalDateTime dataHoraEvento;

	private Long idAluno;
	
	private String nome;
	
	private String cpf;
	
	private LocalDate dataNascimento;
	
	private TipoEventoAluno tipoEvento;

}
