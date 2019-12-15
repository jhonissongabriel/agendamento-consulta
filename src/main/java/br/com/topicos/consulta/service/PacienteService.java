package br.com.topicos.consulta.service;

import java.util.List;

import br.com.topicos.consulta.model.Paciente;

public interface PacienteService {

	public Paciente create(Paciente paciente);

	public void delete(Long id);

	public List<Paciente> todos();

	public Paciente buscarId(Long id);

	public List<Paciente> buscarPaciente(String nome);
	
	public List<Paciente> buscarTelefonePaciente(String telefone);

	public List<Paciente> buscarAgendaData(String data);
	
	public List<Paciente> buscarAgendaEspecialidade(String especialidade);

	public List<Paciente> buscarAgendaConsultorio(String consultorio);

}
