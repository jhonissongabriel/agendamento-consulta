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
@Table(name = "func_funcionario")
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_func")
	@JsonView({ View.Avancado.class })
	private Long id;

	@Column(name = "func_registro", length = 6, nullable = false)
	@JsonView({ View.Basico.class })
	private String registro;

	@Column(name = "func_data_admissao", length = 10, nullable = false)
	@JsonView({ View.Basico.class })
	private String admissao;

	@Column(name = "func_data_demissao", length = 10, nullable = false)
	@JsonView({ View.Basico.class })
	private String demissao;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

	public String getAdmissao() {
		return admissao;
	}

	public void setAdmissao(String admissao) {
		this.admissao = admissao;
	}

	public String getDemissao() {
		return demissao;
	}

	public void setDemissao(String demissao) {
		this.demissao = demissao;
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

}
