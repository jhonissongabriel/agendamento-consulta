package br.com.topicos.consulta.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.topicos.consulta.model.Contato;

public interface ContatoRepository extends CrudRepository<Contato, Long> {

	public List<Contato> findByTelefone(String telefone);

	public List<Contato> findByEmail(String email);

	public List<Contato> findBySite(String site);

	public List<Contato> findByEmailContains(String email);

	public List<Contato> findByTelefoneContains(String telefone);

	public List<Contato> findBySiteContains(String site);

}
