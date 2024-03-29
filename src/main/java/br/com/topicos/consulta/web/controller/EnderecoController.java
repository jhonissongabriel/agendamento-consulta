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

import br.com.topicos.consulta.model.Endereco;
import br.com.topicos.consulta.service.EnderecoService;
import br.com.topicos.consulta.view.View;

@RestController
@RequestMapping(value = "/endereco")
@CrossOrigin
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;

	public void setEnderecoService(EnderecoService enderecoService) {
		this.enderecoService = enderecoService;
	}

	@RequestMapping(value = "/getById", method = RequestMethod.GET, produces = { "application/json",
			"application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Endereco> pesquisarPorId(@RequestParam(value = "id") Long id) {
		return new ResponseEntity<Endereco>(enderecoService.buscarId(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/getRua", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Collection<Endereco>> pesquisarPorRua(@RequestParam(value = "rua") String rua) {
		return new ResponseEntity<Collection<Endereco>>(enderecoService.buscarRua(rua), HttpStatus.OK);
	}

	@RequestMapping(value = "/getNumero", method = RequestMethod.GET, produces = { "application/json",
			"application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Collection<Endereco>> pesquisarPorNumero(@RequestParam(value = "numero") int numero) {
		return new ResponseEntity<Collection<Endereco>>(enderecoService.buscarNumero(numero), HttpStatus.OK);
	}

	@RequestMapping(value = "/getCep", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Collection<Endereco>> pesquisarPorCep(@RequestParam(value = "cep") String cep) {
		return new ResponseEntity<Collection<Endereco>>(enderecoService.buscarCep(cep), HttpStatus.OK);
	}

	@RequestMapping(value = "/getBairro", method = RequestMethod.GET, produces = { "application/json",
			"application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Collection<Endereco>> pesquisarPorBairro(@RequestParam(value = "bairro") String bairro) {
		return new ResponseEntity<Collection<Endereco>>(enderecoService.buscarBairro(bairro), HttpStatus.OK);
	}

	@RequestMapping(value = "/getCidade", method = RequestMethod.GET, produces = { "application/json",
			"application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Collection<Endereco>> pesquisarPorCidade(@RequestParam(value = "cidade") String cidade) {
		return new ResponseEntity<Collection<Endereco>>(enderecoService.buscarCidade(cidade), HttpStatus.OK);
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Collection<Endereco>> getAll() {
		return new ResponseEntity<Collection<Endereco>>(enderecoService.todos(), HttpStatus.OK);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@JsonView(View.Basico.class)
	public ResponseEntity<Endereco> salvar(@RequestBody Endereco endereco, UriComponentsBuilder uriComponentsBuilder) {
		endereco = enderecoService.create(endereco);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setLocation(uriComponentsBuilder.path("/getById/" + endereco.getId()).build().toUri());
		return new ResponseEntity<Endereco>(endereco, responseHeaders, HttpStatus.CREATED);
	}

}
