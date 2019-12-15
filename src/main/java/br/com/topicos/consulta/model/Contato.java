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
@Table(name = "cont_contato")
public class Contato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cont")
	@JsonView({ View.Avancado.class })
	private Long id;
	
	//FUTURO COLOCAR TELEFONE COMO LISTA
	@Column(name = "cont_telefone", length = 11, nullable = false)
	@JsonView({ View.Basico.class })
	private String telefone;
	//FUTURO COLOCAR TELEFONE COMO LISTA
	
	@Column(name = "cont_email", length = 50)
	@JsonView({ View.Basico.class })
	private String email;
	
	@Column(name = "cont_site", length = 50)
	@JsonView({ View.Basico.class })
	private String site;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}
	
	

}
