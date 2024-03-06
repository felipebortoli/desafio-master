package com.pessoas.membros.projeto.membrosprojeto.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pessoas.membros.projeto.membrosprojeto.entity.CargoEntity;
import com.pessoas.membros.projeto.membrosprojeto.entity.PessoaEntity;
import com.pessoas.membros.projeto.membrosprojeto.entity.ProjetoEntity;
import com.pessoas.membros.projeto.membrosprojeto.repository.CargoRepository;

@Service
public class CargoService {

	@Autowired
	private CargoRepository repository;
	
	
	public CargoEntity save(PessoaEntity pessoaEntity, ProjetoEntity projetoEntity, String cargo) {
		CargoEntity entity = new CargoEntity();
		entity.setNome(cargo);
		entity.setPessoa(pessoaEntity);
		entity.setProjeto(projetoEntity);
		return repository.save(entity);
	}
	
	public Optional<CargoEntity> getCargoEntityByIdPessoaAndIdPRojeto(long idPessoa, long idProjeto) {
		return repository.getByidPessoaAndIdProjeto(idPessoa, idProjeto);
	}

	public void save(CargoEntity entity) {
		repository.save(entity);
	}
}
