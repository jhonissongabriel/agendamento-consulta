package br.com.topicos.consulta.service;

import java.util.List;

import br.com.topicos.consulta.model.Pessoa;

public interface PessoaService {

	public Pessoa create(Pessoa pessoa);

	public void delete(Long id);

	public List<Pessoa> todos();

	public Pessoa buscarId(Long id);

	public List<Pessoa> buscarNome(String nome);

	public List<Pessoa> buscarCpf(String cpf);

	public List<Pessoa> buscarDataNascimento(String dataNascimento);

}
