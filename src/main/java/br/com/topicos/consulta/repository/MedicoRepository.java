package br.com.topicos.consulta.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.topicos.consulta.model.Medico;

public interface MedicoRepository extends CrudRepository<Medico, Long> {

	public Medico findByNome(String nome);

	public Medico findByCrm(String crm);
	
	public List<Medico> findByNomeContains(String nome);

	public List<Medico> findByCrmContains(String crm);
	
	
	
	
}
