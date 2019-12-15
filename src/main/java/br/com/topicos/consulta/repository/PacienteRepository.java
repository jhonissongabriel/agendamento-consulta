package br.com.topicos.consulta.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.topicos.consulta.model.Paciente;

public interface PacienteRepository extends CrudRepository<Paciente, Long> {

	public Paciente findByPessoaNome(String nome);

	public Paciente findByPessoaCpf(String cpf);

	public Paciente findByAgendasConsultorioNome(String consultorio);

	public Paciente findByContatoTelefone(String telefone);

	public Paciente findByAgendasData(String data);

	public Paciente findByAgendasEspecialidadeNome(String especialidade);

	public List<Paciente> findByPessoaNomeContains(String nome);

	public List<Paciente> findByPessoaCpfContains(String cpf);

	public List<Paciente> findByAgendasConsultorioNomeContains(String consultorio);

	public List<Paciente> findByContatoTelefoneContains(String telefone);

	public List<Paciente> findByAgendasDataContains(String data);

	public List<Paciente> findByAgendasEspecialidadeNomeContains(String especialidade);

}
