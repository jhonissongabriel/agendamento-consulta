package br.com.topicos.consulta.service;

import java.util.List;

import br.com.topicos.consulta.model.Especialidade;

public interface EspecialidadeService {
	
	public Especialidade create(Especialidade especialidade);
	
	public void delete(Long id);
	
	public List<Especialidade> todos();
	
	public List<Especialidade> buscarEspecialidade(String nome);
	
	public Especialidade buscarId(Long id);

}
