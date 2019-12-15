package br.com.topicos.consulta.service;

import java.util.List;

import br.com.topicos.consulta.model.Endereco;

public interface EnderecoService {

	public Endereco create(Endereco endereco);

	public void delete(Long id);

	public List<Endereco> todos();

	public Endereco buscarId(Long id);

	public List<Endereco> buscarRua(String rua);

	public List<Endereco> buscarNumero(int numero);

	public List<Endereco> buscarBairro(String bairro);

	public List<Endereco> buscarCep(String cep);

	public List<Endereco> buscarCidade(String cidade);

}
