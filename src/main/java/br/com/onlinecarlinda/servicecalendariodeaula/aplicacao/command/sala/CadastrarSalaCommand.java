package br.com.onlinecarlinda.servicecalendariodeaula.aplicacao.command.sala;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.onlinecarlinda.servicecalendariodeaula.aplicacao.event.Evento;
import br.com.onlinecarlinda.servicecalendariodeaula.aplicacao.event.PayloadEvento;
import br.com.onlinecarlinda.servicecalendariodeaula.aplicacao.event.PublicadorEvento;
import br.com.onlinecarlinda.servicecalendariodeaula.aplicacao.event.TipoEvento;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.service.SalaService;

@Service
public class CadastrarSalaCommand {
	
	@Autowired
	private SalaService salaService;
	
	@Autowired
	private PublicadorEvento publisher;
	
	private Evento evento;
	
	private String mensagem;
	
	public String executa(String nome, String nomeGradeHorario, List<Long> idsEstacoes) {
		
		
		
		try {
			
			salaService.cadastarSala(nome, nomeGradeHorario, idsEstacoes);
			
			this.evento = new Evento(this, new PayloadEvento("mailon", "192.198.5.17", TipoEvento.INSERSAO));
			mensagem = "Sala Cadastrada";
		} catch (Exception e) {
			e.printStackTrace();
			mensagem = e.getMessage();
			this.evento = new Evento(this, new PayloadEvento("mailon", "192.198.5.17", TipoEvento.ERRO));
			
		}finally {
			
			publisher.publish(evento);
		}
		
		return mensagem;
	}

}
