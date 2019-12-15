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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonView;

import br.com.topicos.consulta.view.View;

@Entity
@Table(name = "cons_consultorio")
public class Consultorio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cons")
	@JsonView({ View.Avancado.class })
	private Long id;

	@Column(name = "cons_nome", length = 10, nullable = false)
	@JsonView({ View.Basico.class })
	private String nome;

	@Column(name = "cons_cnpj", length = 5, nullable = false)
	@JsonView({ View.Basico.class })
	private String cnpj;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "ce_consultorio_especialidade", joinColumns = {
			@JoinColumn(name = "cons_id") }, inverseJoinColumns = { @JoinColumn(name = "espe_id") })
	@JsonView({ View.Basico.class })
	private List<Especialidade> especialidades;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	@JoinTable(name = "cm_consultorio_medico", joinColumns = {
			@JoinColumn(name = "cons_id") }, inverseJoinColumns = { @JoinColumn(name = "medi_id") })
	@JsonView({ View.Basico.class })
	private List<Medico> medicos;

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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public List<Especialidade> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(List<Especialidade> especialidades) {
		this.especialidades = especialidades;
	}

	public List<Medico> getMedicos() {
		return medicos;
	}

	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
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

	
	
	

}
