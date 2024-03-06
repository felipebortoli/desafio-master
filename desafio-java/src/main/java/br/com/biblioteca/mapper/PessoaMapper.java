package br.com.biblioteca.mapper;


import java.util.ArrayList;
import java.util.List;

import br.com.biblioteca.dto.GerenteDTO;

import br.com.biblioteca.model.PessoaEntity;


public class PessoaMapper {

	
	public GerenteDTO EntitytoDTO(PessoaEntity pessoaEntity) {
		GerenteDTO dto = new GerenteDTO();
		dto.setIdPessoa(pessoaEntity.getId());
		dto.setNome(pessoaEntity.getNome());
		return dto;
	}
	
	public List<GerenteDTO> EntitytoDTOList(List<PessoaEntity> entityList) {
		List<GerenteDTO> gerenteDTOList = new ArrayList<GerenteDTO>();
		for(PessoaEntity pessoaEntity : entityList) {
			GerenteDTO dto = new GerenteDTO();
			dto.setIdPessoa(pessoaEntity.getId());
			dto.setNome(pessoaEntity.getNome());
			gerenteDTOList.add(dto);
		}
		return gerenteDTOList;
	}
	
   

}
