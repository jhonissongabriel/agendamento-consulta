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

import br.com.topicos.consulta.model.Especialidade;
import br.com.topicos.consulta.service.EspecialidadeService;
import br.com.topicos.consulta.view.View;

@RestController
@RequestMapping(value = "/especialidade")
@CrossOrigin
public class EspecialidadeController {

	@Autowired
	private EspecialidadeService especialidadeService;

	public void setEspecialidadeService(EspecialidadeService especialidadeService) {
		this.especialidadeService = especialidadeService;
	}

	@RequestMapping(value = "/getById", method = RequestMethod.GET, produces = { "application/json",
			"application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Especialidade> pesquisarPorId(@RequestParam(value = "id", defaultValue = "1") Long id) {
		return new ResponseEntity<Especialidade>(especialidadeService.buscarId(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/getEspecialidade", method = RequestMethod.GET, produces = { "application/json",
			"application/xml" })
	@JsonView(View.Basico.class)
	@ResponseBody
	public ResponseEntity<Collection<Especialidade>> pesquisarPorEspecialidade(
			@RequestParam(value = "nome") String nome) {
		return new ResponseEntity<Collection<Especialidade>>(especialidadeService.buscarEspecialidade(nome), HttpStatus.OK);
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Collection<Especialidade>> getAll() {
		return new ResponseEntity<Collection<Especialidade>>(especialidadeService.todos(), HttpStatus.OK);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = { "application/json",
			"application/xml" }, produces = { "application/json", "application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Especialidade> salvar(@RequestBody Especialidade especialidade,
			UriComponentsBuilder uriComponentsBuilder) {
		especialidade = especialidadeService.create(especialidade);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setLocation(uriComponentsBuilder.path("/getById/" + especialidade.getId()).build().toUri());
		return new ResponseEntity<Especialidade>(especialidade, responseHeaders, HttpStatus.CREATED);
	}

}
