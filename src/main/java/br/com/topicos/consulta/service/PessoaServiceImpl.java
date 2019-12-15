package br.com.topicos.consulta.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.topicos.consulta.model.Pessoa;
import br.com.topicos.consulta.repository.PessoaRepository;

@Service("pessoaService")
@Transactional
@PreAuthorize("isAuthenticated()")
public class PessoaServiceImpl implements PessoaService {

	@Autowired
	private PessoaRepository pessoaRepo;

	public void setPessoaRepo(PessoaRepository pessoaRepo) {
		this.pessoaRepo = pessoaRepo;
	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Pessoa create(Pessoa pessoa) {
		return pessoaRepo.save(pessoa);
	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void delete(Long id) {
		pessoaRepo.deleteById(id);
	}

	@Override
	@PreAuthorize("isAuthenticated()")
	public List<Pessoa> todos() {
		List<Pessoa> retorno = new ArrayList<Pessoa>();
		for (Pessoa pessoa : pessoaRepo.findAll()) {
			retorno.add(pessoa);
		}
		return retorno;
	}

	@Override
	@PreAuthorize("isAuthenticated()")
	public Pessoa buscarId(Long id) {
		Optional<Pessoa> pessoa = pessoaRepo.findById(id);
		if (pessoa.isPresent()) {
			return pessoa.get();
		}
		return null;
	}

	@Override
	@PreAuthorize("isAuthenticated()")
	public List<Pessoa> buscarNome(String nome) {
		List<Pessoa> retorno = new ArrayList<Pessoa>();
		for (Pessoa pessoa : pessoaRepo.findByNomeContains(nome)) {
			retorno.add(pessoa);
		}
		return retorno;
	}

	@Override
	@PreAuthorize("isAuthenticated()")
	public List<Pessoa> buscarCpf(String cpf) {
		List<Pessoa> retorno = new ArrayList<Pessoa>();
		for (Pessoa pessoa : pessoaRepo.findByCpfContains(cpf)) {
			retorno.add(pessoa);
		}
		return retorno;
	}

	@Override
	@PreAuthorize("isAuthenticated()")
	public List<Pessoa> buscarDataNascimento(String dataNascimento) {
		List<Pessoa> retorno = new ArrayList<Pessoa>();
		for (Pessoa pessoa : pessoaRepo.findByDataNascContains(dataNascimento)) {
			retorno.add(pessoa);
		}
		return retorno;
	}

}
