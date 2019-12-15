package br.com.topicos.consulta.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.topicos.consulta.model.Funcionario;

public interface FuncionarioRepository extends CrudRepository<Funcionario, Long> {

	public List<Funcionario> findByRegistro(String registro);

	public List<Funcionario> findByAdmissao(String admissao);

	public List<Funcionario> findByDemissao(String demissao);

	public List<Funcionario> findByRegistroContains(String registro);

	public List<Funcionario> findByAdmissaoContains(String admissao);

	public List<Funcionario> findByDemissaoContains(String demissao);

}
