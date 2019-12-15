package br.com.topicos.consulta.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import br.com.topicos.consulta.view.View;

@Entity
@Table(name = "agen_agenda")
public class Agenda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_agen")
	@JsonView({ View.Avancado.class })
	private Long id;

	@Column(name = "agen_data", length = 10, nullable = false)
	@JsonView({ View.Basico.class })
	private String data;

	@Column(name = "agen_horario", length = 5, nullable = false)
	@JsonView({ View.Basico.class })
	private String horario;
	
	@ManyToOne
	@JoinColumn(name = "cons_id")
	@JsonView({ View.Basico.class })
	private Consultorio consultorio;

	@ManyToOne
	@JoinColumn(name = "espe_id")
	@JsonView({ View.Basico.class })
	private Especialidade especialidade;

	@ManyToOne
	@JoinColumn(name = "medi_id")
	@JsonView({ View.Basico.class })
	private Medico medico;

	@ManyToOne
	@JoinColumn(name = "ende_id")
	@JsonView({ View.Basico.class })
	private Endereco endereco;

	@ManyToOne
	@JoinColumn(name = "cont_id")
	@JsonView({ View.Basico.class })
	private Contato contato;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	public Consultorio getConsultorio() {
		return consultorio;
	}

	public void setConsultorio(Consultorio consultorio) {
		this.consultorio = consultorio;
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

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

}
