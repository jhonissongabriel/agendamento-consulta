package br.com.topicos.consulta.service;

import java.util.List;

import br.com.topicos.consulta.model.Consultorio;

public interface ConsultorioService {
	
	public Consultorio create(Consultorio consultorio);
	
	public void delete(Long id);
	
	public List<Consultorio> todos();
	
	public Consultorio buscarId(Long id);
	
	public List<Consultorio> buscarConsultorio(String nome);
	
	public List<Consultorio> buscarCnpj(String cnpj);
	
	public List<Consultorio> buscarEspecialidade(String especialidade);
	
	public List<Consultorio> buscarMedico(String medico);
	
	public List<Consultorio> buscarCidade(String cidade);

}
