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

import br.com.topicos.consulta.model.Funcionario;
import br.com.topicos.consulta.service.FuncionarioService;
import br.com.topicos.consulta.view.View;

@RestController
@RequestMapping(value = "/funcionario")
@CrossOrigin
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;

	public void setFuncionarioService(FuncionarioService funcionarioService) {
		this.funcionarioService = funcionarioService;
	}

	@RequestMapping(value = "/getById", method = RequestMethod.GET)
	@JsonView(View.Basico.class)
	public ResponseEntity<Funcionario> pesquisarPorId(@RequestParam(value = "id") Long id) {
		return new ResponseEntity<Funcionario>(funcionarioService.buscarId(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/getRegistro", method = RequestMethod.GET, produces = { "application/json",
			"application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Collection<Funcionario>> pesquisarPorRegistro(
			@RequestParam(value = "registro") String registro) {
		return new ResponseEntity<Collection<Funcionario>>(funcionarioService.buscarRegistro(registro), HttpStatus.OK);
	}

	@RequestMapping(value = "/getDataAdmissao", method = RequestMethod.GET, produces = { "application/json",
			"application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Collection<Funcionario>> pesquisarPorAdmissao(
			@RequestParam(value = "dataAdmissao") String dataAdmissao) {
		return new ResponseEntity<Collection<Funcionario>>(funcionarioService.buscarDataAdmissao(dataAdmissao),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/getDataDemissao", method = RequestMethod.GET, produces = { "application/json",
			"application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Collection<Funcionario>> pesquisarPorDemissao(
			@RequestParam(value = "dataDemissao") String dataDemissao) {
		return new ResponseEntity<Collection<Funcionario>>(funcionarioService.buscarDataDemissao(dataDemissao),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	@JsonView(View.Basico.class)
	public ResponseEntity<Collection<Funcionario>> getAll() {
		return new ResponseEntity<Collection<Funcionario>>(funcionarioService.todos(), HttpStatus.OK);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@JsonView(View.Basico.class)
	public ResponseEntity<Funcionario> salvar(@RequestBody Funcionario funcionario,
			UriComponentsBuilder uriComponentsBuilder) {
		funcionario = funcionarioService.create(funcionario);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setLocation(uriComponentsBuilder.path("/getById/" + funcionario.getId()).build().toUri());
		return new ResponseEntity<Funcionario>(funcionario, responseHeaders, HttpStatus.CREATED);
	}

}
