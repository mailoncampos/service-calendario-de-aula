package br.com.onlinecarlinda.servicecalendariodeaula.aplicacao.command.sala;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.onlinecarlinda.servicecalendariodeaula.aplicacao.event.Evento;
import br.com.onlinecarlinda.servicecalendariodeaula.aplicacao.event.PayloadEvento;
import br.com.onlinecarlinda.servicecalendariodeaula.aplicacao.event.PublicadorEvento;
import br.com.onlinecarlinda.servicecalendariodeaula.aplicacao.event.TipoEvento;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.sala.Sala;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.service.SalaService;

@Service
public class CadastrarSalaCommand {
	
	@Autowired
	private SalaService salaService;
	
	@Autowired
	private PublicadorEvento publisher;
	
	private Evento evento;
	
	private String mensagem;
	
	public String executa(Sala sala, String nomeModelo) {
		
		
		
		try {
			
			salaService.cadastarSala(sala, nomeModelo);
			
			this.evento = new Evento(this, new PayloadEvento("mailon", "192.198.5.17", TipoEvento.INSERSAO), sala);
			mensagem = "Sala Cadastrada";
		} catch (Exception e) {
			mensagem = e.getMessage();
			this.evento = new Evento(this, new PayloadEvento("mailon", "192.198.5.17", TipoEvento.ERRO), sala);
			
		}finally {
			publisher.publish(evento);
		}
		
		return mensagem;
	}

}
