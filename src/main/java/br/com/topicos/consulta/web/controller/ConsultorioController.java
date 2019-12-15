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

import br.com.topicos.consulta.model.Consultorio;
import br.com.topicos.consulta.service.ConsultorioService;
import br.com.topicos.consulta.view.View;

@RestController
@RequestMapping(value = "/consultorio")
@CrossOrigin
public class ConsultorioController {

	@Autowired
	private ConsultorioService consultorioService;

	public void setconsultorioService(ConsultorioService consultorioService) {
		this.consultorioService = consultorioService;
	}

	@RequestMapping(value = "/getById", method = RequestMethod.GET, produces = { "application/json",
	"application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Consultorio> pesquisarPorId(@RequestParam(value = "id") Long id) {
		return new ResponseEntity<Consultorio>(consultorioService.buscarId(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/getConsultorio", method = RequestMethod.GET, produces = { "application/json",
	"application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Collection<Consultorio>> pesquisarPorNome(@RequestParam(value = "nome") String nome) {
		return new ResponseEntity<Collection<Consultorio>>(consultorioService.buscarConsultorio(nome), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getEspecialidade", method = RequestMethod.GET, produces = { "application/json",
	"application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Collection<Consultorio>> pesquisarPorEspecialidade(@RequestParam(value = "especialidade") String especialidade) {
		return new ResponseEntity<Collection<Consultorio>>(consultorioService.buscarEspecialidade(especialidade), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getMedico", method = RequestMethod.GET, produces = { "application/json",
	"application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Collection<Consultorio>> pesquisarPorMedico(@RequestParam(value = "medico") String medico) {
		return new ResponseEntity<Collection<Consultorio>>(consultorioService.buscarMedico(medico), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getCidade", method = RequestMethod.GET, produces = { "application/json",
	"application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Collection<Consultorio>> pesquisarPorCidade(@RequestParam(value = "cidade") String cidade) {
		return new ResponseEntity<Collection<Consultorio>>(consultorioService.buscarCidade(cidade), HttpStatus.OK);
	}

	@RequestMapping(value = "/getCnpj", method = RequestMethod.GET, produces = { "application/json",
	"application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Collection<Consultorio>> pesquisarPorCnpj(@RequestParam(value = "cnpj") String cnpj) {
		return new ResponseEntity<Collection<Consultorio>>(consultorioService.buscarCnpj(cnpj), HttpStatus.OK);
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = { "application/json",
	"application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Collection<Consultorio>> getAll() {
		return new ResponseEntity<Collection<Consultorio>>(consultorioService.todos(), HttpStatus.OK);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@JsonView(View.Basico.class)
	public ResponseEntity<Consultorio> salvar(@RequestBody Consultorio Consultorio,
			UriComponentsBuilder uriComponentsBuilder) {
		Consultorio = consultorioService.create(Consultorio);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setLocation(uriComponentsBuilder.path("/getById/" + Consultorio.getId()).build().toUri());
		return new ResponseEntity<Consultorio>(Consultorio, responseHeaders, HttpStatus.CREATED);
	}

}
