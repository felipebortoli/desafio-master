package br.com.biblioteca.service;

import java.util.List;

import br.com.biblioteca.dto.GerenteDTO;
import br.com.biblioteca.model.PessoaEntity;
import br.com.biblioteca.model.ProjetoEntity;


public interface IPessoaService {

	List <GerenteDTO> listByGerente();
	
	PessoaEntity getById(long id);
	
	List<PessoaEntity> listFuncionarios();
}
