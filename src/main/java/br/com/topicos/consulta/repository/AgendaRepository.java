package br.com.topicos.consulta.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.topicos.consulta.model.Agenda;

public interface AgendaRepository extends CrudRepository<Agenda, Long>{
	
	public List<Agenda> findByData(String data);

	public List<Agenda> findByHorario(String horario);
	
	public List<Agenda> findByDataContains(String data);

	public List<Agenda> findByHorarioContains(String horario);

}
