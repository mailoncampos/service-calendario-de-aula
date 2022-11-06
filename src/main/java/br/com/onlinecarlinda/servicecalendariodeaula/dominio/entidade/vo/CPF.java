package br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
public class CPF implements FabricaCPF{
	
	@Setter
	private String cpf;

}
