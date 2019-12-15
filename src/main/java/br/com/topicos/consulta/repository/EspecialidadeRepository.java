package br.com.topicos.consulta.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.topicos.consulta.model.Especialidade;

public interface EspecialidadeRepository extends CrudRepository<Especialidade,Long>{
	
	public List<Especialidade> findByNome(String nome);
	
	public List<Especialidade> findByNomeContains(String nome);

}
