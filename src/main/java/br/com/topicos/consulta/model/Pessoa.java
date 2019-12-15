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
@Table(name = "pess_pessoa")
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pess")
	@JsonView({View.Avancado.class})
	private Long id;

	@Column(name = "pess_nome", length = 100, nullable = false)
	@JsonView({View.Basico.class})
	private String nome;

	@Column(name = "pess_cpf", length = 11, unique = true, nullable = false)
	//@JsonView({View.Intermediario.class})
	@JsonView({View.Basico.class})
	private String cpf;
	
	@Column(name = "pess_data_nasc",length = 10, nullable = false)
	@JsonView({View.Basico.class})
	private String dataNasc;

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}
	
	

}
