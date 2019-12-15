package br.com.topicos.consulta.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.topicos.consulta.model.Contato;
import br.com.topicos.consulta.repository.ContatoRepository;

@Service("contatoService")
@Transactional
@PreAuthorize("isAuthenticated()")
public class ContatoServiceImpl implements ContatoService {

	@Autowired
	private ContatoRepository contatoRepo;

	public void setContatoRepo(ContatoRepository contatoRepo) {
		this.contatoRepo = contatoRepo;
	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Contato create(Contato contato) {
		return contatoRepo.save(contato);
	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void delete(Long id) {
		contatoRepo.deleteById(id);
	}

	@Override
	@PreAuthorize("isAuthenticated()")
	public List<Contato> todos() {
		List<Contato> retorno = new ArrayList<Contato>();
		for (Contato contato : contatoRepo.findAll()) {
			retorno.add(contato);
		}
		return retorno;
	}

	@Override
	@PreAuthorize("isAuthenticated()")
	public Contato buscarId(Long id) {
		Optional<Contato> contato = contatoRepo.findById(id);
		if (contato.isPresent()) {
			return contato.get();
		}
		return null;
	}

	@Override
	@PreAuthorize("isAuthenticated()")
	public List<Contato> buscarTelefone(String telefone) {
		List<Contato> retorno = new ArrayList<Contato>();
		for (Contato contato : contatoRepo.findByTelefoneContains(telefone)) {
			retorno.add(contato);
		}
		return retorno;
	}

	@Override
	@PreAuthorize("isAuthenticated()")
	public List<Contato> buscarEmail(String email) {
		List<Contato> retorno = new ArrayList<Contato>();
		for (Contato contato : contatoRepo.findByEmailContains(email)) {
			retorno.add(contato);
		}
		return retorno;
	}

	@Override
	@PreAuthorize("isAuthenticated()")
	public List<Contato> buscarSite(String site) {
		List<Contato> retorno = new ArrayList<Contato>();
		for (Contato contato : contatoRepo.findBySiteContains(site)) {
			retorno.add(contato);
		}
		return retorno;
	}

}
