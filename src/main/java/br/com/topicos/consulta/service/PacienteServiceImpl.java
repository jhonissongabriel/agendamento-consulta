package br.com.topicos.consulta.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.topicos.consulta.model.Paciente;
import br.com.topicos.consulta.repository.PacienteRepository;

@Service("pacienteService")
@Transactional
@PreAuthorize("isAuthenticated()")
public class PacienteServiceImpl implements PacienteService {

	@Autowired
	private PacienteRepository pacienteRepo;

	public void setPacienteRepo(PacienteRepository pacienteRepo) {
		this.pacienteRepo = pacienteRepo;
	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Paciente create(Paciente paciente) {
		return pacienteRepo.save(paciente);
	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void delete(Long id) {
		pacienteRepo.deleteById(id);
	}

	@Override
	@PreAuthorize("isAuthenticated()")
	public List<Paciente> todos() {
		List<Paciente> retorno = new ArrayList<Paciente>();
		for (Paciente paciente : pacienteRepo.findAll()) {
			retorno.add(paciente);
		}
		return retorno;
	}

	@Override
	@PreAuthorize("isAuthenticated()")
	public Paciente buscarId(Long id) {
		Optional<Paciente> paciente = pacienteRepo.findById(id);
		if (paciente.isPresent()) {
			return paciente.get();
		}
		return null;
	}

	@Override
	@PreAuthorize("isAuthenticated()")
	public List<Paciente> buscarPaciente(String nome) {
		List<Paciente> retorno = new ArrayList<Paciente>();
		for (Paciente paciente : pacienteRepo.findByPessoaNomeContains(nome)) {
			retorno.add(paciente);
		}
		return retorno;
	}

	@Override
	public List<Paciente> buscarTelefonePaciente(String telefone) {
		List<Paciente> retorno = new ArrayList<Paciente>();
		for (Paciente paciente : pacienteRepo.findByContatoTelefoneContains(telefone)) {
			retorno.add(paciente);
		}
		return retorno;
	}

	@Override
	@PreAuthorize("isAuthenticated()")
	public List<Paciente> buscarAgendaData(String data) {
		List<Paciente> retorno = new ArrayList<Paciente>();
		for (Paciente paciente : pacienteRepo.findByAgendasDataContains(data)) {
			retorno.add(paciente);
		}
		return retorno;
	}

	@Override
	@PreAuthorize("isAuthenticated()")
	public List<Paciente> buscarAgendaEspecialidade(String especialidade) {
		List<Paciente> retorno = new ArrayList<Paciente>();
		for (Paciente paciente : pacienteRepo.findByAgendasEspecialidadeNomeContains(especialidade)) {
			retorno.add(paciente);
		}
		return retorno;
	}

	@Override
	@PreAuthorize("isAuthenticated()")
	public List<Paciente> buscarAgendaConsultorio(String consultorio) {
		List<Paciente> retorno = new ArrayList<Paciente>();
		for (Paciente paciente : pacienteRepo.findByAgendasConsultorioNomeContains(consultorio)) {
			retorno.add(paciente);
		}
		return retorno;
	}

}
