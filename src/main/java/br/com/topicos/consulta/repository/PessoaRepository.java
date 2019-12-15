package br.com.topicos.consulta.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.topicos.consulta.model.Pessoa;

public interface PessoaRepository extends CrudRepository<Pessoa, Long> {

	public List<Pessoa> findByNome(String nome);

	public Pessoa findByCpf(String cpf);

	public List<Pessoa> findByDataNasc(String dataNasc);

	public List<Pessoa> findByNomeContains(String nome);

	public List<Pessoa> findByCpfContains(String cpf);

	public List<Pessoa> findByDataNascContains(String dataNasc);

}
