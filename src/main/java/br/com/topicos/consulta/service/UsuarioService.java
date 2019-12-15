package br.com.topicos.consulta.service;

import java.util.List;

import br.com.topicos.consulta.model.Usuario;

public interface UsuarioService {
	
	public Usuario incluirUsuario(String nome, String senha, String nomeAutorizacao);
	
	public List<Usuario> buscarUsuario(String usuario);
	
	public Usuario buscar(Long id);
	
	public List<Usuario> todos();
	
	public Usuario salvar(Usuario usuario);

}
