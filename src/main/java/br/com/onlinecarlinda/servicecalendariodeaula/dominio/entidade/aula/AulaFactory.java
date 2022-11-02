package br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aula;

public interface AulaFactory{
	
	public AulaBuilder cadastrar(Aula aula);
		
	public Aula criar();

}
