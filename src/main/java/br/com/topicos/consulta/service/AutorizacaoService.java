package br.com.topicos.consulta.service;

import java.util.List;

import br.com.topicos.consulta.model.Autorizacao;

public interface AutorizacaoService {
	
	public Autorizacao salvar(Autorizacao autorizacao);
	
	public void excluir(Long idAutorizacao);
	
	public List<Autorizacao> todos();
	
	public List<Autorizacao> buscar(String nome);
	
	public Autorizacao buscarPorId(Long idAutorizacao);

}
