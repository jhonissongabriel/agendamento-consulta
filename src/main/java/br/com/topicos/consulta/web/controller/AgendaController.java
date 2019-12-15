package br.com.topicos.consulta.web.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonView;

import br.com.topicos.consulta.model.Agenda;
import br.com.topicos.consulta.service.AgendaService;
import br.com.topicos.consulta.view.View;

@RestController
@RequestMapping(value = "/agenda")
@CrossOrigin
public class AgendaController {

	@Autowired
	private AgendaService agendaService;

	public void setAgendaService(AgendaService agendaService) {
		this.agendaService = agendaService;
	}

	@RequestMapping(value = "/getById", method = RequestMethod.GET, produces = { "application/json",
			"application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Agenda> pesquisarPorId(@RequestParam(value = "id", defaultValue = "1") Long id) {
		return new ResponseEntity<Agenda>(agendaService.buscarId(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/getData", method = RequestMethod.GET, produces = { "application/json",
			"application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Collection<Agenda>> pesquisarPorData(@RequestParam(value = "data") String data) {
		return new ResponseEntity<Collection<Agenda>>(agendaService.buscarData(data), HttpStatus.OK);
	}

	@RequestMapping(value = "/getHorario", method = RequestMethod.GET, produces = { "application/json",
			"application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Collection<Agenda>> pesquisarPorHorario(@RequestParam(value = "horario") String horario) {
		return new ResponseEntity<Collection<Agenda>>(agendaService.buscarHorario(horario), HttpStatus.OK);
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Collection<Agenda>> getAll() {
		return new ResponseEntity<Collection<Agenda>>(agendaService.todos(), HttpStatus.OK);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@JsonView(View.Basico.class)
	public ResponseEntity<Agenda> salvar(@RequestBody Agenda agenda, UriComponentsBuilder uriComponentsBuilder) {
		agenda = agendaService.create(agenda);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setLocation(uriComponentsBuilder.path("/getById/" + agenda.getId()).build().toUri());
		return new ResponseEntity<Agenda>(agenda, responseHeaders, HttpStatus.CREATED);
	}

}
