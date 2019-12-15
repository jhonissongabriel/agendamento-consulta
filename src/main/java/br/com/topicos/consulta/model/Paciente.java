package br.com.topicos.consulta.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import br.com.topicos.consulta.view.View;

@Entity
@Table(name = "paci_paciente")
public class Paciente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_paci")
	@JsonView({ View.Avancado.class })
	private Long id;

	@ManyToOne
	@JoinColumn(name = "pess_id")
	@JsonView({ View.Avancado.class })
	private Pessoa pessoa;
	
	@ManyToOne
	@JoinColumn(name = "ende_id")
	@JsonView({ View.Avancado.class })
	private Endereco endereco;
	
	@ManyToOne
	@JoinColumn(name = "cont_id")
	@JsonView({ View.Avancado.class })
	private Contato contato;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "ap_agenda_paciente", joinColumns = { @JoinColumn(name = "paci_id") }, inverseJoinColumns = {
			@JoinColumn(name = "agen_id") })
	@JsonView({ View.Basico.class })
	private List<Agenda> agendas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public List<Agenda> getAgendas() {
		return agendas;
	}

	public void setAgendas(List<Agenda> agendas) {
		this.agendas = agendas;
	}
	
	
	
}
