package br.com.onlinecarlinda.servicecalendariodeaula.dominio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.estacaoestudo.EstacaoEstudo;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.estacaoestudo.EstacaoEstudoRepository;

@Service
public class EstacaoEstudoService {
	
	@Autowired
	private EstacaoEstudoRepository estacaoEstudoRepository;
	
	public List<EstacaoEstudo> buscarEstacoesEstudoPorIds(List<Long> idEstacoes){
		return estacaoEstudoRepository.buscarEstacoesEstudoPorIds(idEstacoes);
	}

}
