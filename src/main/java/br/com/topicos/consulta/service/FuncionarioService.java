package br.com.topicos.consulta.service;

import java.util.List;

import br.com.topicos.consulta.model.Funcionario;

public interface FuncionarioService {
	
	public Funcionario create(Funcionario funcionario);
	
	public void delete(Long id);
	
	public List<Funcionario> todos();
	
	public Funcionario buscarId(Long id);
	
	public List<Funcionario> buscarRegistro(String registro);
	
	public List<Funcionario> buscarDataAdmissao(String dataAdmissao);
	
	public List<Funcionario> buscarDataDemissao(String dataDemissao);
	
	
}
