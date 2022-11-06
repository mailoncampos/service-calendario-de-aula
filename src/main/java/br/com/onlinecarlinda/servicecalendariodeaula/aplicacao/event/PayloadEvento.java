package br.com.onlinecarlinda.servicecalendariodeaula.aplicacao.event;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PayloadEvento {
	
	private UUID eventId = UUID.randomUUID();

	private String usuario;
	
	private String ip;
	
	private LocalDateTime dataHoraEvento = LocalDateTime.now();
	
	private String tipoEvento;
	
	public PayloadEvento(String usuario,  String ip, TipoEvento tipo) {
		this.usuario = usuario;
		this.ip = ip;
		this.tipoEvento = tipo.toString();
	}
	
}
