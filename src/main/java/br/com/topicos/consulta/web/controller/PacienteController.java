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

import br.com.topicos.consulta.model.Paciente;
import br.com.topicos.consulta.service.PacienteService;
import br.com.topicos.consulta.view.View;

@RestController
@RequestMapping(value = "/paciente")
@CrossOrigin
public class PacienteController {

	@Autowired
	private PacienteService pacienteService;

	public void setPacienteService(PacienteService pacienteService) {
		this.pacienteService = pacienteService;
	}

	@RequestMapping(value = "/getById", method = RequestMethod.GET, produces = { "application/json",
			"application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Paciente> pesquisarPorId(@RequestParam(value = "id") Long id) {
		return new ResponseEntity<Paciente>(pacienteService.buscarId(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Collection<Paciente>> getAll() {
		return new ResponseEntity<Collection<Paciente>>(pacienteService.todos(), HttpStatus.OK);
	}

	@RequestMapping(value = "/getPaciente", method = RequestMethod.GET, produces = { "application/json",
			"application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Collection<Paciente>> pesquisarPorPaciente(@RequestParam(value = "nome") String nome) {
		return new ResponseEntity<Collection<Paciente>>(pacienteService.buscarPaciente(nome), HttpStatus.OK);
	}

	@RequestMapping(value = "/getTelefone", method = RequestMethod.GET, produces = { "application/json",
			"application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Collection<Paciente>> pesquisarPorTelefonePaciente(
			@RequestParam(value = "telefone") String telefone) {
		return new ResponseEntity<Collection<Paciente>>(pacienteService.buscarTelefonePaciente(telefone),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/getAgendaData", method = RequestMethod.GET, produces = { "application/json",
			"application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Collection<Paciente>> pesquisarPorAgendaData(@RequestParam(value = "data") String data) {
		return new ResponseEntity<Collection<Paciente>>(pacienteService.buscarAgendaData(data), HttpStatus.OK);
	}

	@RequestMapping(value = "/getAgendaEspecialidade", method = RequestMethod.GET, produces = { "application/json",
			"application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Collection<Paciente>> pesquisarPorAgendaEspecialidade(
			@RequestParam(value = "especialidade") String especialidade) {
		return new ResponseEntity<Collection<Paciente>>(pacienteService.buscarAgendaEspecialidade(especialidade),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/getAgendaConsultorio", method = RequestMethod.GET, produces = { "application/json",
			"application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Collection<Paciente>> pesquisarPorAgendaConsultorio(
			@RequestParam(value = "consultorio") String consultorio) {
		return new ResponseEntity<Collection<Paciente>>(pacienteService.buscarAgendaConsultorio(consultorio),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@JsonView(View.Basico.class)
	public ResponseEntity<Paciente> salvar(@RequestBody Paciente paciente, UriComponentsBuilder uriComponentsBuilder) {
		paciente = pacienteService.create(paciente);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setLocation(uriComponentsBuilder.path("/getById/" + paciente.getId()).build().toUri());
		return new ResponseEntity<Paciente>(paciente, responseHeaders, HttpStatus.CREATED);
	}

}
