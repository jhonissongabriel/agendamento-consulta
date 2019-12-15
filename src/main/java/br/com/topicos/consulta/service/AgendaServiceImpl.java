package br.com.topicos.consulta.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.topicos.consulta.model.Agenda;
import br.com.topicos.consulta.repository.AgendaRepository;

@Service("agendaService")
@Transactional
@PreAuthorize("isAuthenticated()")
public class AgendaServiceImpl implements AgendaService {

	@Autowired
	private AgendaRepository agendaRepo;

	public void setAgendaRepo(AgendaRepository agendaRepo) {
		this.agendaRepo = agendaRepo;
	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Agenda create(Agenda agenda) {
		return agendaRepo.save(agenda);
	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void delete(Long id) {
		agendaRepo.deleteById(id);

	}

	@Override
	@PreAuthorize("isAuthenticated()")
	public List<Agenda> todos() {
		List<Agenda> retorno = new ArrayList<Agenda>();
		for (Agenda agenda : agendaRepo.findAll()) {
			retorno.add(agenda);
		}
		return retorno;
	}

	@Override
	@PreAuthorize("isAuthenticated()")
	public Agenda buscarId(Long id) {
		Optional<Agenda> agenda = agendaRepo.findById(id);
		if (agenda.isPresent()) {
			return agenda.get();
		}
		return null;
	}

	@Override
	@PreAuthorize("isAuthenticated()")
	public List<Agenda> buscarData(String data) {
		List<Agenda> retorno = new ArrayList<Agenda>();
		for (Agenda agenda : agendaRepo.findByDataContains(data)) {
			retorno.add(agenda);
		}
		return retorno;
	}

	@Override
	@PreAuthorize("isAuthenticated()")
	public List<Agenda> buscarHorario(String horario) {
		List<Agenda> retorno = new ArrayList<Agenda>();
		for (Agenda agenda : agendaRepo.findByHorarioContains(horario)) {
			retorno.add(agenda);
		}
		return retorno;
	}

}
