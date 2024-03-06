package com.pessoas.membros.projeto.membrosprojeto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pessoas.membros.projeto.membrosprojeto.entity.ProjetoEntity;
import com.pessoas.membros.projeto.membrosprojeto.repository.ProjetoRepository;

@Service
public class ProjetoService {

	@Autowired
	private ProjetoRepository repository;
	
	public ProjetoEntity getProjetoEntityById(long id) {
		return repository.findById(id).get();
	}
}
