package br.com.onlinecarlinda.servicecalendariodeaula.infra.horarioaula;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.onlinecarlinda.servicecalendariodeaula.aplicacao.cadastrar.CadastrarHorarioAula;
import br.com.onlinecarlinda.servicecalendariodeaula.aplicacao.dto.CadastrarHorarioAulaDto;
import br.com.onlinecarlinda.servicecalendariodeaula.core.exception.HorarioAulaException;

@RestController
@RequestMapping("/horario-aula")
public class HorarioAulaRestControler {
	
	@Autowired
	private HorarioAulaRepositoryJpa horarioAulaRepositoryJpa;
	
	private CadastrarHorarioAula cadastrarHorarioAula;
	
	@PostMapping
	public ResponseEntity<HorarioAulaException> cadastrar(@RequestBody CadastrarHorarioAulaDto horarioAulaDto) {
		
		cadastrarHorarioAula = new CadastrarHorarioAula(horarioAulaRepositoryJpa);
		
		try {
			cadastrarHorarioAula.executa(horarioAulaDto);	
			return ResponseEntity.status(HttpStatus.CREATED).body(null);
		}catch (HorarioAulaException e) {
			return ResponseEntity.status(HttpStatus.OK).body(e);
		}
		
	}

}
