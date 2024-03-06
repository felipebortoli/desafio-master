package br.com.biblioteca.mapper;

import java.time.LocalDate;
import java.util.List;

import br.com.biblioteca.dto.GerenteDTO;
import br.com.biblioteca.dto.ProjectDTO;
import br.com.biblioteca.dto.response.ProjetoResponse;
import br.com.biblioteca.enums.Status;
import br.com.biblioteca.model.PessoaEntity;
import br.com.biblioteca.model.ProjetoEntity;

public class ProjectMapper {

	
	public ProjetoEntity DTOtoEntity(ProjectDTO dto, PessoaEntity pessoaEntity) {
		ProjetoEntity entity = new ProjetoEntity();
		entity.setId(dto.getId() != null ? dto.getId() : null);
		entity.setNome(dto.getNome());
		LocalDate dataInicio = this.isNotNullAndNotEmpty(dto.getData_inicio()) ? LocalDate.parse(dto.getData_inicio()) : null;
		LocalDate dataPrevisaoFim = this.isNotNullAndNotEmpty(dto.getData_previsao_fim()) ? LocalDate.parse(dto.getData_previsao_fim()) : null;
		LocalDate dataFim = this.isNotNullAndNotEmpty(dto.getData_fim()) ? LocalDate.parse(dto.getData_fim()) : null;
		entity.setData_inicio(dataInicio);
		entity.setData_previsao_fim(dataPrevisaoFim);
		entity.setData_fim(dataFim);
		entity.setDescricao(dto.getDescricao());
		entity.setStatus(dto.getStatus());
		entity.setClassificacaoRisco(dto.getClassificacaoRisco());
		entity.setOrcamento(dto.getOrcamento());
		entity.setGerente(pessoaEntity);
		return entity;
	}
	
	public ProjetoResponse entityToResponse(ProjetoEntity entity) {
		ProjetoResponse response = new ProjetoResponse();
		response.setId(entity.getId());
		response.setNome(entity.getNome());
		response.setDescricao(entity.getDescricao());
		String dataInicio = entity.getData_inicio() != null ? entity.getData_inicio().toString() : "";
		String dataPrevisaoFim =entity.getData_previsao_fim()!= null ? entity.getData_previsao_fim().toString() : "";
		String dataFim = entity.getData_fim() != null ? entity.getData_fim().toString() : "";
		response.setData_inicio(dataInicio);
		response.setData_previsao_fim(dataPrevisaoFim);
		response.setData_fim(dataFim);
		String status = entity.getStatus() != null ? entity.getStatus().getText() : "";
		response.setStatus(status);
		String nomeGerente = entity.getGerente() != null ? entity.getGerente().getNome() : "";
		response.setGerente(nomeGerente);
		response.setOrcamento(entity.getOrcamento());
		return response;
	}
	
	public ProjectDTO EntitytoDTO(ProjetoEntity entity, List<GerenteDTO> gerentes) {
		ProjectDTO dto = new ProjectDTO();
		dto.setId(entity.getId());
		dto.setNome(entity.getNome());
		String dataInicio = entity.getData_inicio() != null ? entity.getData_inicio().toString() : "";
		String dataPrevisaoFim =entity.getData_previsao_fim()!= null ? entity.getData_previsao_fim().toString() : "";
		String dataFim = entity.getData_fim() != null ? entity.getData_previsao_fim().toString() : "";
		dto.setData_inicio(dataInicio);
		dto.setData_previsao_fim(dataPrevisaoFim);
		dto.setData_fim(dataFim);
		dto.setDescricao(entity.getDescricao());
		dto.setClassificacaoRisco(entity.getClassificacaoRisco());
		dto.setStatus(entity.getStatus());
		dto.setOrcamento(entity.getOrcamento());
		dto.setGerentes(gerentes);
		long idGerente = entity.getGerente() != null ? entity.getGerente().getId() : 0;
		dto.setGerenteProjetoId(idGerente);
		
		return dto;
	}
	
	
    private boolean isNotNullAndNotEmpty(String str) {
        return str != null && !str.isEmpty();
    }

}
