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

import br.com.topicos.consulta.model.Pessoa;
import br.com.topicos.consulta.service.PessoaService;
import br.com.topicos.consulta.view.View;

@RestController
@RequestMapping(value = "/pessoa")
@CrossOrigin
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;

	public void setPessoaService(PessoaService pessoaService) {
		this.pessoaService = pessoaService;
	}

	@RequestMapping(value = "/getById", method = RequestMethod.GET, produces = { "application/json",
			"application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Pessoa> pesquisarPorId(@RequestParam(value = "id") Long id) {
		return new ResponseEntity<Pessoa>(pessoaService.buscarId(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	@JsonView(View.Avancado.class)
	public ResponseEntity<Collection<Pessoa>> getAll() {
		return new ResponseEntity<Collection<Pessoa>>(pessoaService.todos(), HttpStatus.OK);
	}

	@RequestMapping(value = "/getNome", method = RequestMethod.GET, produces = { "application/json",
			"application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Collection<Pessoa>> pesquisarPorNome(@RequestParam(value = "nome") String nome) {
		return new ResponseEntity<Collection<Pessoa>>(pessoaService.buscarNome(nome), HttpStatus.OK);
	}

	@RequestMapping(value = "/getCpf", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Collection<Pessoa>> pesquisarPorCpf(@RequestParam(value = "cpf") String cpf) {
		return new ResponseEntity<Collection<Pessoa>>(pessoaService.buscarCpf(cpf), HttpStatus.OK);
	}

	@RequestMapping(value = "/getDataNascimento", method = RequestMethod.GET, produces = { "application/json",
			"application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Collection<Pessoa>> pesquisarPorDataNascimento(
			@RequestParam(value = "dataNascimento") String dataNascimento) {
		return new ResponseEntity<Collection<Pessoa>>(pessoaService.buscarDataNascimento(dataNascimento),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@JsonView(View.Basico.class)
	public ResponseEntity<Pessoa> salvar(@RequestBody Pessoa pessoa, UriComponentsBuilder uriComponentsBuilder) {
		pessoa = pessoaService.create(pessoa);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setLocation(uriComponentsBuilder.path("/getById/" + pessoa.getId()).build().toUri());
		return new ResponseEntity<Pessoa>(pessoa, responseHeaders, HttpStatus.CREATED);
	}

}
