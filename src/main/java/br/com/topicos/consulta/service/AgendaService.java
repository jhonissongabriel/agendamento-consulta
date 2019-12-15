package br.com.topicos.consulta.service;

import java.util.List;

import br.com.topicos.consulta.model.Agenda;

public interface AgendaService {

	public Agenda create(Agenda agenda);

	public void delete(Long id);

	public List<Agenda> todos();

	public Agenda buscarId(Long id);

	public List<Agenda> buscarData(String data);

	public List<Agenda> buscarHorario(String horario);

}
