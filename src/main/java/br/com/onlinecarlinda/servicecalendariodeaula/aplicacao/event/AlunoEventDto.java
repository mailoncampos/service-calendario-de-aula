package br.com.onlinecarlinda.servicecalendariodeaula.aplicacao.event;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import br.com.onlinecarlinda.servicecalendariodeaula.aplicacao.command.TipoEventoAluno;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aluno.Aluno;
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
	
	public Aluno criarAluno(AlunoEventDto alunoDto) {
		return new Aluno(alunoDto.getNome(), alunoDto.getCpf(), alunoDto.getTipoEvento().toString());
	}

}
