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
@Table(name = "espe_especialidade")
public class Especialidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_espe")
	@JsonView({ View.Avancado.class })
	private Long id;

	@Column(name = "espe_nome", length = 50, nullable = false)
	@JsonView({ View.Basico.class })
	private String nome;

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
	
	
	
}
