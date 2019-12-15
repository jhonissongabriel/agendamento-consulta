package br.com.topicos.consulta.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.topicos.consulta.model.Consultorio;

public interface ConsultorioRepository extends CrudRepository<Consultorio, Long> {

	public Consultorio findByNome(String nome);

	public Consultorio findByCnpj(String cnpj);
	
	public Consultorio findByEspecialidadesNome(String especialidade);
	
	public Consultorio findByMedicosNome(String medico);
	
	public List<Consultorio> findByEnderecoCidade(String cidade);

	public List<Consultorio> findByNomeContains(String nome);

	public List<Consultorio> findByCnpjContains(String cnpj);
	
	public List<Consultorio> findByEspecialidadesNomeContains(String especialidade);
	
	public List<Consultorio> findByMedicosNomeContains(String medico);
	
	public List<Consultorio> findByEnderecoCidadeContains(String cidade);

	
	

}
