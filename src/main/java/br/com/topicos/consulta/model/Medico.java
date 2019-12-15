package br.com.topicos.consulta.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import br.com.topicos.consulta.view.View;

@Entity
@Table(name = "medi_medico")
public class Medico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_medi")
	@JsonView({ View.Avancado.class })
	private Long id;
	
	@Column(name = "medi_nome", length = 100, nullable = false)
	@JsonView({ View.Basico.class })
	private String nome;
	
	@Column(name = "medi_crm", length = 10, nullable = false)
	@JsonView({ View.Basico.class })
	private String crm;

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

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}
	
	

}
