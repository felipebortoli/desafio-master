package com.pessoas.membros.projeto.membrosprojeto.mapper;

import com.pessoas.membros.projeto.membrosprojeto.dto.MembrosResponse;
import com.pessoas.membros.projeto.membrosprojeto.entity.MembrosProjectEntity;

public class MembrosProjetoMapper {

	public MembrosResponse entityToResponse(MembrosProjectEntity entity) {
		MembrosResponse response = new MembrosResponse();
		//response.setCargo(entity.getCargo());
		response.setNome(entity.getIdPessoa().getNome());
		return response;
	}

}
