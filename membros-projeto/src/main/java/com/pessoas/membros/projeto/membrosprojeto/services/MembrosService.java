package com.pessoas.membros.projeto.membrosprojeto.services;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pessoas.membros.projeto.membrosprojeto.dto.MembrosRequest;
import com.pessoas.membros.projeto.membrosprojeto.dto.MembrosResponse;
import com.pessoas.membros.projeto.membrosprojeto.entity.CargoEntity;
import com.pessoas.membros.projeto.membrosprojeto.entity.MembrosProjectEntity;
import com.pessoas.membros.projeto.membrosprojeto.entity.PessoaEntity;
import com.pessoas.membros.projeto.membrosprojeto.entity.ProjetoEntity;
import com.pessoas.membros.projeto.membrosprojeto.mapper.MembrosProjetoMapper;
import com.pessoas.membros.projeto.membrosprojeto.repository.MembrosRepository;


@Service
public class MembrosService {
	
	private final MembrosRepository repository;
	private final MembrosProjetoMapper mapper;
	
	@Autowired
	private ProjetoService projetoService;
	
	@Autowired
	private PessoaService pessoaService;
	
	@Autowired
	private CargoService cargoService;
	
	
	public MembrosService(MembrosRepository repository,PessoaService pessoaService) {
		this.repository = repository;
		this.pessoaService = pessoaService;
		this.mapper = new MembrosProjetoMapper();
	}



	public MembrosResponse cadastrarMembro(MembrosRequest membrosRequest) {
		MembrosResponse response = new MembrosResponse();
		long idPessoa = membrosRequest.getIdPessoa();
		long idProjeto = membrosRequest.getIdProjeto();
		String cargo = membrosRequest.getCargo();
		PessoaEntity pessoaEntity = pessoaService.getPessoaEntityById(idPessoa);
		ProjetoEntity projetoEntity = projetoService.getProjetoEntityById(idProjeto);
		
		Optional<CargoEntity> cargoOptional = cargoService.getCargoEntityByIdPessoaAndIdPRojeto(idPessoa, idProjeto);
		CargoEntity cargoEntity;
		if(cargoOptional.isPresent()) {
			cargoEntity = cargoOptional.get();
			cargoEntity.setNome(cargo);
			cargoService.save(cargoEntity);
		}else {
			cargoEntity = cargoService.save(pessoaEntity,projetoEntity, cargo);
		}
		
		MembrosProjectEntity membrosProjectEntity = new MembrosProjectEntity();
		membrosProjectEntity.setIdPessoa(pessoaEntity);
		membrosProjectEntity.setIdprojeto(membrosRequest.getIdProjeto());
		repository.save(membrosProjectEntity);
		
		response.setNome(pessoaEntity.getNome());
		response.setCargo(cargoEntity.getNome());
		return response;
	}
	
	public List<MembrosResponse> getListMembros(MembrosRequest membrosRequest) {
		List<MembrosResponse> listResponse = new ArrayList<MembrosResponse>();
		List<MembrosProjectEntity> listMembros = repository.findAll();
		for(MembrosProjectEntity entity : listMembros) {
			listResponse.add(mapper.entityToResponse(entity));
		}
		
		return listResponse;
	}
	
	public List<MembrosResponse> getListMembrosFuncioanrios(long idProjeto) {
		List<MembrosResponse> listResponse = pessoaService.getPessoasToAddProjeto(idProjeto);
				
		return listResponse;
	}
	

}
