package br.com.biblioteca.service;

import java.util.List;
import java.util.Optional;

import br.com.biblioteca.dto.GerenteDTO;
import br.com.biblioteca.dto.MembrosDTO;
import br.com.biblioteca.dto.ProjectDTO;
import br.com.biblioteca.dto.response.ProjetoResponse;
import br.com.biblioteca.model.ProjetoEntity;

public interface IProjectService {
	
	List <ProjetoResponse> list();
	
	List <GerenteDTO> listGerentes();

	ProjectDTO getProjectById(long id);

    void update(ProjectDTO projectDTO) throws Exception;

    void delete(long id) throws Exception;

    void save(ProjectDTO project) throws Exception;
    
    List<MembrosDTO> getMembrosToAddProjeto(long id) throws Exception;
    
    void saveMembro(MembrosDTO membroProjeto) throws Exception;

}
