package br.com.biblioteca.service;

import java.net.ConnectException;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.biblioteca.dto.GerenteDTO;
import br.com.biblioteca.dto.MembrosDTO;
import br.com.biblioteca.dto.ProjectDTO;
import br.com.biblioteca.dto.response.ProjetoResponse;
import br.com.biblioteca.enums.Status;
import br.com.biblioteca.mapper.ProjectMapper;
import br.com.biblioteca.model.PessoaEntity;
import br.com.biblioteca.model.ProjetoEntity;
import br.com.biblioteca.repository.ProjectRepository;

@Service
@Transactional
public class ProjectServiceImpl implements IProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;
	private final ProjectMapper projectMapper;
	private final IPessoaService pessoaService;
	@Autowired
	private MembrosProjetoSenderService membrosProjetoSenderService;
	
	public ProjectServiceImpl(ProjectMapper projectMapper, IPessoaService pessoaService ) {
		this.pessoaService = pessoaService;
		this.projectMapper = projectMapper;
	}

	@Override
	public List<ProjetoResponse> list() {
		List<ProjetoEntity> entityList = projectRepository.list();
		List<ProjetoResponse> responseList = new ArrayList<ProjetoResponse>();
		for(ProjetoEntity projetoEntity : entityList) {
			responseList.add(projectMapper.entityToResponse(projetoEntity));
		}
		
		return responseList;
	}

	@Override
	public ProjectDTO getProjectById(long id) {
		ProjetoEntity projetoEntity = projectRepository.getProjectById(id);
		List<GerenteDTO> gerentes = pessoaService.listByGerente();
		return projectMapper.EntitytoDTO(projetoEntity, gerentes);
	}

	@Override
	public void update(ProjectDTO projectDTO) throws Exception {
		try {
	        PessoaEntity pessoaEntity = null;
	        long gerenteProjetoId = projectDTO.getGerenteProjetoId();

	        if (gerenteProjetoId != 0) {
	            pessoaEntity = pessoaService.getById(gerenteProjetoId);
	        }

	        ProjetoEntity entity = projectMapper.DTOtoEntity(projectDTO, pessoaEntity);
	        ProjetoEntity savedEntity = projectRepository.save(entity);

	        membrosProjetoSenderService.createMembrosProjeto(pessoaEntity.getId(), savedEntity.getId(), "Gerente");
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	        throw new Exception("Projeto não foi criado", e);
	    }
					
	}

	@Override
	public void delete(long id) throws Exception {
		ProjetoEntity entity = projectRepository.getProjectById(id);
		if(entity != null) {
			if(Status.INICIADO == entity.getStatus() || Status.EM_ANDAMENTO == entity.getStatus() || Status.ENCERRADO == entity.getStatus()) {
				throw new Exception("Não é permitido exclusão de projeto com status: " + entity.getStatus().getText() );
			}
			projectRepository.delete(entity);
		}
	}

	@Override
	public void save(ProjectDTO projectDto) throws Exception {
		try {
	        PessoaEntity pessoaEntity = null;
	        long gerenteProjetoId = projectDto.getGerenteProjetoId();

	        if (gerenteProjetoId != 0) {
	            pessoaEntity = pessoaService.getById(gerenteProjetoId);
	        }

	        ProjetoEntity entity = projectMapper.DTOtoEntity(projectDto, pessoaEntity);
	        ProjetoEntity savedEntity = projectRepository.save(entity);

	        membrosProjetoSenderService.createMembrosProjeto(pessoaEntity.getId(), savedEntity.getId(), "Gerente");
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	        throw new Exception("Projeto não foi criado", e);
	    }
					
	}

	@Override
	public List<GerenteDTO> listGerentes() {
		return pessoaService.listByGerente();
	}

	@Override
	public List<MembrosDTO> getMembrosToAddProjeto(long idProjeto) throws Exception {
		List<PessoaEntity> listPessoas = pessoaService.listFuncionarios();
	    List<MembrosDTO> membrosList = new ArrayList<>();

	    // Create a map using stream and Collectors.toMap
	    Map<Long, MembrosDTO> membrosMap = listPessoas.stream()
	            .map(entity -> {
	                MembrosDTO dto = new MembrosDTO();
	                dto.setIdPessoa(entity.getId());
	                dto.setCargo("");
	                dto.setGerente(entity.isGerente() ? "SIM" : "NÃO");
	                dto.setNome(entity.getNome());
	                return dto;
	            })
	            .collect(Collectors.toMap(MembrosDTO::getIdPessoa, Function.identity()));

	    // Update existing members with data from membrosProjetoSenderService
	    membrosProjetoSenderService.listMembrosProjeto(idProjeto)
	            .forEach(dto -> membrosMap.put(dto.getIdPessoa(), dto));

	    return new ArrayList<>(membrosMap.values());
	}

	@Override
	public void saveMembro(MembrosDTO membroProjeto) throws Exception {
		try {
			membrosProjetoSenderService.createMembrosProjeto(membroProjeto.getIdPessoa(),membroProjeto.getIdProjeto(), membroProjeto.getCargo());
		} catch (InterruptedException e) {
			e.printStackTrace();
			throw new Exception("Não foi possivel salvar membro");
		}catch (ConnectException e) {
			e.printStackTrace();
			throw new Exception("Não foi possivel salvar membro");
        }catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Não foi possivel salvar membro");
		}
		
	}


}
