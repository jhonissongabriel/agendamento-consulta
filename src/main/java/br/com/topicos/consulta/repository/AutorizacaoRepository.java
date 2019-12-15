package br.com.topicos.consulta.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.topicos.consulta.model.Autorizacao;


public interface AutorizacaoRepository extends CrudRepository<Autorizacao, Long> {
	
	public Autorizacao findByNome(String nome);
	
	public List<Autorizacao> findByNomeContains(String nome);
	
	public List<Autorizacao> findByNomeContainsIgnoreCase(String nome);

}
