package br.com.topicos.consulta.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.topicos.consulta.model.Especialidade;
import br.com.topicos.consulta.repository.EspecialidadeRepository;

@Service("especialidadeService")
@Transactional
@PreAuthorize("isAuthenticated()")
public class EspecialidadeServiceImpl implements EspecialidadeService {

	@Autowired
	private EspecialidadeRepository especialidadeRepo;

	public void setEspecialidadeRepo(EspecialidadeRepository especialidadeRepo) {
		this.especialidadeRepo = especialidadeRepo;
	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Especialidade create(Especialidade especialidade) {
		return especialidadeRepo.save(especialidade);
	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void delete(Long id) {
		especialidadeRepo.deleteById(id);
	}

	@Override
	@PreAuthorize("isAuthenticated()")
	public List<Especialidade> todos() {
		List<Especialidade> retorno = new ArrayList<Especialidade>();
		for (Especialidade especialidade : especialidadeRepo.findAll()) {
			retorno.add(especialidade);
		}
		return retorno;
	}

	@Override
	@PreAuthorize("isAuthenticated()")
	public List<Especialidade> buscarEspecialidade(String nome) {
		if (nome == null || nome.isEmpty()) {
			return todos();
		}
		return especialidadeRepo.findByNomeContains(nome);
	}

	@Override
	@PreAuthorize("isAuthenticated()")
	public Especialidade buscarId(Long id) {
		Optional<Especialidade> especialidade = especialidadeRepo.findById(id);
		if (especialidade.isPresent()) {
			return especialidade.get();
		}
		return null;
	}

}
