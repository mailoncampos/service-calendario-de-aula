package br.com.onlinecarlinda.servicecalendariodeaula.aplicacao.event;

import java.util.function.Consumer;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import br.com.onlinecarlinda.servicecalendariodeaula.aplicacao.command.AlunoService;

public class AlunoConsumerConfig {
	
	@Autowired
	private AlunoService alunoService;
	
	@Bean			//"Recebe o evento"
    public Consumer<KStream<String, AlunoEventDto>> novaMatriculaRealizada(){
		return kstream -> kstream.foreach((key, aluno) -> {
		      System.out.println(String.format("Nome aluno:[%s], CPF:[%s]", aluno.getNome(), aluno.getCpf()));
		    });
	}
	 
//	private Mono<AlunoEventDto> processaAtualizacao(AlunoEventDto alunoEvent) {
//
//        if(TipoEventoAluno.MATRICULADO.equals(alunoEvent.getTipoEvento())){
//        	return Mono.fromSupplier(()->this.alunoService.novoAlunoMatriculado(alunoEvent.criarAluno(alunoEvent)));
//        }
//		return null;
//    }

}
