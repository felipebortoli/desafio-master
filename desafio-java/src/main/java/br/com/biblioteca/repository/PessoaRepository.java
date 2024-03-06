package br.com.biblioteca.repository;

import java.util.List;

import br.com.biblioteca.model.PessoaEntity;


public interface PessoaRepository {

	
	List <PessoaEntity> listByGerente();
	
	PessoaEntity getById(long id);
	
	List <PessoaEntity> listByFuncionario();
}
