package br.com.topicos.consulta.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.topicos.consulta.model.Consultorio;
import br.com.topicos.consulta.repository.ConsultorioRepository;

@Service("consultorioService")
@Transactional
@PreAuthorize("isAuthenticated()")
public class ConsultorioServiceImpl implements ConsultorioService {

	@Autowired
	private ConsultorioRepository consultorioRepo;

	public void setConsultorioRepo(ConsultorioRepository consultorioRepo) {
		this.consultorioRepo = consultorioRepo;
	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Consultorio create(Consultorio consultorio) {
		return consultorioRepo.save(consultorio);
	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void delete(Long id) {
		consultorioRepo.deleteById(id);
	}

	@Override
	@PreAuthorize("isAuthenticated()")
	public List<Consultorio> todos() {
		List<Consultorio> retorno = new ArrayList<Consultorio>();
		for (Consultorio consultorio : consultorioRepo.findAll()) {
			retorno.add(consultorio);
		}
		return retorno;
	}

	@Override
	@PreAuthorize("isAuthenticated()")
	public Consultorio buscarId(Long id) {
		Optional<Consultorio> consultorio = consultorioRepo.findById(id);
		if (consultorio.isPresent()) {
			return consultorio.get();
		}
		return null;
	}

	@Override
	@PreAuthorize("isAuthenticated()")
	public List<Consultorio> buscarConsultorio(String nome) {
		List<Consultorio> retorno = new ArrayList<Consultorio>();
		for (Consultorio consultorio : consultorioRepo.findByNomeContains(nome)) {
			retorno.add(consultorio);
		}
		return retorno;
	}

	@Override
	@PreAuthorize("isAuthenticated()")
	public List<Consultorio> buscarCnpj(String cnpj) {
		List<Consultorio> retorno = new ArrayList<Consultorio>();
		for (Consultorio consultorio : consultorioRepo.findByCnpjContains(cnpj)) {
			retorno.add(consultorio);
		}
		return retorno;
	}

	@Override
	@PreAuthorize("isAuthenticated()")
	public List<Consultorio> buscarEspecialidade(String especialidade) {
		List<Consultorio> retorno = new ArrayList<Consultorio>();
		for (Consultorio consultorio : consultorioRepo.findByEspecialidadesNomeContains(especialidade)) {
			retorno.add(consultorio);
		}
		return retorno;
	}

	@Override
	@PreAuthorize("isAuthenticated()")
	public List<Consultorio> buscarMedico(String medico) {
		List<Consultorio> retorno = new ArrayList<Consultorio>();
		for (Consultorio consultorio : consultorioRepo.findByMedicosNomeContains(medico)) {
			retorno.add(consultorio);
		}
		return retorno;
	}

	@Override
	@PreAuthorize("isAuthenticated()")
	public List<Consultorio> buscarCidade(String cidade) {
		List<Consultorio> retorno = new ArrayList<Consultorio>();
		for (Consultorio consultorio : consultorioRepo.findByEnderecoCidadeContains(cidade)) {
			retorno.add(consultorio);
		}
		return retorno;
	}

}
