package br.com.biblioteca.repository;

import java.util.List;


import br.com.biblioteca.model.ProjetoEntity;


public interface ProjectRepository {

	List <ProjetoEntity> list();

	ProjetoEntity getProjectById(long id);

    void delete(ProjetoEntity projectEntity);

    ProjetoEntity save(ProjetoEntity projectEntity);
    
    List <ProjetoEntity> listFuncionarios();
}
