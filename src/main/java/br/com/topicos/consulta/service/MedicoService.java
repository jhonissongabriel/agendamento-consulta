package br.com.topicos.consulta.service;

import java.util.List;

import br.com.topicos.consulta.model.Medico;

public interface MedicoService {

	public Medico create(Medico medico);

	public void delete(Long id);

	public List<Medico> todos();

	public List<Medico> buscarNome(String nome);

	public List<Medico> buscarCrm(String crm);

	public Medico buscarId(Long id);

}
