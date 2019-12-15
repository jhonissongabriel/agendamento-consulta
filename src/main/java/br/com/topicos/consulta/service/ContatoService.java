package br.com.topicos.consulta.service;

import java.util.List;

import br.com.topicos.consulta.model.Contato;

public interface ContatoService {

	public Contato create(Contato contato);

	public void delete(Long id);

	public List<Contato> todos();

	public Contato buscarId(Long id);

	public List<Contato> buscarTelefone(String telefone);

	public List<Contato> buscarEmail(String email);

	public List<Contato> buscarSite(String site);

}
