package br.com.topicos.consulta.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.topicos.consulta.model.Funcionario;
import br.com.topicos.consulta.repository.FuncionarioRepository;

@Service("funcionarioService")
@Transactional
@PreAuthorize("isAuthenticated()")
public class FuncionarioServiceImpl implements FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepo;

	public void setFuncionarioRepo(FuncionarioRepository funcionarioRepo) {
		this.funcionarioRepo = funcionarioRepo;
	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Funcionario create(Funcionario funcionario) {
		return funcionarioRepo.save(funcionario);
	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void delete(Long id) {
		funcionarioRepo.deleteById(id);
	}

	@Override
	@PreAuthorize("isAuthenticated()")
	public List<Funcionario> todos() {
		List<Funcionario> retorno = new ArrayList<Funcionario>();
		for (Funcionario funcionario : funcionarioRepo.findAll()) {
			retorno.add(funcionario);
		}
		return retorno;
	}

	@Override
	@PreAuthorize("isAuthenticated()")
	public Funcionario buscarId(Long id) {
		Optional<Funcionario> funcionario = funcionarioRepo.findById(id);
		if (funcionario.isPresent()) {
			return funcionario.get();
		}
		return null;
	}

	@Override
	@PreAuthorize("isAuthenticated()")
	public List<Funcionario> buscarRegistro(String registro) {
		List<Funcionario> retorno = new ArrayList<Funcionario>();
		for (Funcionario funcionario : funcionarioRepo.findByRegistroContains(registro)) {
			retorno.add(funcionario);
		}
		return retorno;
	}

	@Override
	@PreAuthorize("isAuthenticated()")
	public List<Funcionario> buscarDataAdmissao(String dataAdmissao) {
		List<Funcionario> retorno = new ArrayList<Funcionario>();
		for (Funcionario funcionario : funcionarioRepo.findByAdmissaoContains(dataAdmissao)) {
			retorno.add(funcionario);
		}
		return retorno;
	}

	@Override
	@PreAuthorize("isAuthenticated()")
	public List<Funcionario> buscarDataDemissao(String dataDemissao) {
		List<Funcionario> retorno = new ArrayList<Funcionario>();
		for (Funcionario funcionario : funcionarioRepo.findByDemissaoContains(dataDemissao)) {
			retorno.add(funcionario);
		}
		return retorno;
	}

}
