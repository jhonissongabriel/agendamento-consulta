package br.com.topicos.consulta.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.topicos.consulta.model.Endereco;
import br.com.topicos.consulta.repository.EnderecoRepository;

@Service("enderecoService")
@Transactional
@PreAuthorize("isAuthenticated()")
public class EnderecoServiceImpl implements EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepo;

	public void setEnderecoRepo(EnderecoRepository enderecoRepo) {
		this.enderecoRepo = enderecoRepo;
	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Endereco create(Endereco endereco) {
		return enderecoRepo.save(endereco);
	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void delete(Long id) {
		enderecoRepo.deleteById(id);
	}

	@Override
	@PreAuthorize("isAuthenticated()")
	public List<Endereco> todos() {
		List<Endereco> retorno = new ArrayList<Endereco>();
		for (Endereco endereco : enderecoRepo.findAll()) {
			retorno.add(endereco);
		}
		return retorno;
	}

	@Override
	@PreAuthorize("isAuthenticated()")
	public Endereco buscarId(Long id) {
		Optional<Endereco> endereco = enderecoRepo.findById(id);
		if (endereco.isPresent()) {
			return endereco.get();
		}
		return null;
	}

	@Override
	@PreAuthorize("isAuthenticated()")
	public List<Endereco> buscarRua(String rua) {
		List<Endereco> retorno = new ArrayList<Endereco>();
		for (Endereco endereco : enderecoRepo.findByRuaContains(rua)) {
			retorno.add(endereco);
		}
		return retorno;
	}

	@Override
	@PreAuthorize("isAuthenticated()")
	public List<Endereco> buscarNumero(int numero) {
		List<Endereco> retorno = new ArrayList<Endereco>();
		for (Endereco endereco : enderecoRepo.findByNumeroContains(numero)) {
			retorno.add(endereco);
		}
		return retorno;
	}

	@Override
	@PreAuthorize("isAuthenticated()")
	public List<Endereco> buscarBairro(String bairro) {
		List<Endereco> retorno = new ArrayList<Endereco>();
		for (Endereco endereco : enderecoRepo.findByBairroContains(bairro)) {
			retorno.add(endereco);
		}
		return retorno;
	}

	@Override
	@PreAuthorize("isAuthenticated()")
	public List<Endereco> buscarCep(String cep) {
		List<Endereco> retorno = new ArrayList<Endereco>();
		for (Endereco endereco : enderecoRepo.findByCepContains(cep)) {
			retorno.add(endereco);
		}
		return retorno;
	}

	@Override
	@PreAuthorize("isAuthenticated()")
	public List<Endereco> buscarCidade(String cidade) {
		List<Endereco> retorno = new ArrayList<Endereco>();
		for (Endereco endereco : enderecoRepo.findByCidadeContains(cidade)) {
			retorno.add(endereco);
		}
		return retorno;
	}

}
