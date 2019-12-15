package br.com.topicos.consulta.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.topicos.consulta.model.Endereco;

public interface EnderecoRepository extends CrudRepository<Endereco, Long> {

	public List<Endereco> findByRua(String rua);

	public List<Endereco> findByNumero(int numero);

	public List<Endereco> findByCep(String cep);

	public List<Endereco> findByBairro(String bairro);

	public List<Endereco> findByCidade(String cidade);
	

	public List<Endereco> findByRuaContains(String rua);

	public List<Endereco> findByNumeroContains(int numero);

	public List<Endereco> findByCepContains(String cep);

	public List<Endereco> findByBairroContains(String bairro);

	public List<Endereco> findByCidadeContains(String cidade);

}
