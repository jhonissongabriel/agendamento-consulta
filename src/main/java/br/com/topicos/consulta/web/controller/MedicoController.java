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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonView;

import br.com.topicos.consulta.model.Medico;
import br.com.topicos.consulta.service.MedicoService;
import br.com.topicos.consulta.view.View;

@RestController
@RequestMapping(value = "/medico")
@CrossOrigin
public class MedicoController {

	@Autowired
	private MedicoService medicoService;

	public void setMedicoService(MedicoService medicoService) {
		this.medicoService = medicoService;
	}

	@RequestMapping(value = "/getById", method = RequestMethod.GET, produces = { "application/json",
			"application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Medico> pesquisarPorId(@RequestParam(value = "id", defaultValue = "1") Long id) {
		return new ResponseEntity<Medico>(medicoService.buscarId(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/getMedico", method = RequestMethod.GET, produces = { "application/json",
			"application/xml" })
	@JsonView(View.Basico.class)
	@ResponseBody
	public ResponseEntity<Collection<Medico>> pesquisarPorNome(@RequestParam(value = "nome") String nome) {
		return new ResponseEntity<Collection<Medico>>(medicoService.buscarNome(nome), HttpStatus.OK);
	}

	@RequestMapping(value = "/getCrm", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	@JsonView(View.Basico.class)
	@ResponseBody
	public ResponseEntity<Collection<Medico>> pesquisarPorCrm(@RequestParam(value = "crm") String crm) {
		return new ResponseEntity<Collection<Medico>>(medicoService.buscarCrm(crm), HttpStatus.OK);
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Collection<Medico>> getAll() {
		return new ResponseEntity<Collection<Medico>>(medicoService.todos(), HttpStatus.OK);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = { "application/json",
			"application/xml" }, produces = { "application/json", "application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Medico> salvar(@RequestBody Medico medico, UriComponentsBuilder uriComponentsBuilder) {
		medico = medicoService.create(medico);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setLocation(uriComponentsBuilder.path("/getById/" + medico.getId()).build().toUri());
		return new ResponseEntity<Medico>(medico, responseHeaders, HttpStatus.CREATED);
	}

}
