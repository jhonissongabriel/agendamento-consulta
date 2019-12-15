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
@Table(name = "ende_endereco")
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ende")
	@JsonView({ View.Avancado.class })
	private Long id;

	@Column(name = "ende_rua", length = 100, nullable = false)
	@JsonView({ View.Basico.class })
	private String rua;

	@Column(name = "ende_numero", nullable = false)
	@JsonView({ View.Basico.class })
	private int numero;
	
	@Column(name = "ende_edificio", length = 50)
	@JsonView({ View.Basico.class })
	private String edificio;
	
	@Column(name = "ende_andar", length = 20)
	@JsonView({ View.Basico.class })
	private String andar;
	
	@Column(name = "ende_sala", length = 20)
	@JsonView({ View.Basico.class })
	private String sala;
	
	@Column(name = "ende_cep", length = 9, nullable = false)
	@JsonView({ View.Basico.class })
	private String cep;
	
	@Column(name = "ende_bairro", length = 50, nullable = false)
	@JsonView({ View.Basico.class })
	private String bairro;
	
	@Column(name = "ende_cidade", length = 50, nullable = false)
	@JsonView({ View.Basico.class })
	private String cidade;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	
	


}
