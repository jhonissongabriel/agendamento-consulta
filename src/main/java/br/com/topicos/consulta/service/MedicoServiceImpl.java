package br.com.topicos.consulta.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.topicos.consulta.model.Medico;
import br.com.topicos.consulta.repository.MedicoRepository;

@Service("medicoService")
@Transactional
@PreAuthorize("isAuthenticated()")
public class MedicoServiceImpl implements MedicoService {

	@Autowired
	private MedicoRepository medicoRepo;

	public void setMedicoRepo(MedicoRepository medicoRepo) {
		this.medicoRepo = medicoRepo;
	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Medico create(Medico medico) {
		return medicoRepo.save(medico);
	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void delete(Long id) {
		medicoRepo.deleteById(id);
	}

	@Override
	@PreAuthorize("isAuthenticated()")
	public List<Medico> todos() {
		List<Medico> retorno = new ArrayList<Medico>();
		for (Medico medico : medicoRepo.findAll()) {
			retorno.add(medico);
		}
		return retorno;
	}

	@Override
	@PreAuthorize("isAuthenticated()")
	public List<Medico> buscarNome(String nome) {
		if (nome == null || nome.isEmpty()) {
			return todos();
		}
		return medicoRepo.findByNomeContains(nome);
	}

	@Override
	@PreAuthorize("isAuthenticated()")
	public List<Medico> buscarCrm(String crm) {
		if (crm == null || crm.isEmpty()) {
			return todos();
		}
		return medicoRepo.findByCrmContains(crm);
	}

	@Override
	@PreAuthorize("isAuthenticated()")
	public Medico buscarId(Long id) {
		Optional<Medico> medico = medicoRepo.findById(id);
		if (medico.isPresent()) {
			return medico.get();
		}
		return null;
	}

}
