package com.pessoas.membros.projeto.membrosprojeto.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pessoas.membros.projeto.membrosprojeto.dto.MembrosResponse;
import com.pessoas.membros.projeto.membrosprojeto.entity.PessoaEntity;
import com.pessoas.membros.projeto.membrosprojeto.repository.PessoaRepository;

import jakarta.persistence.Tuple;



@Service
public class PessoaService {
	

	@Autowired
	private PessoaRepository repository;
	
	
	public PessoaEntity getPessoaEntityById(long id) {
		return repository.findById(id).get();
	}
	
	
	public  List<MembrosResponse> getPessoasToAddProjeto(long idProjeto){
		List<Tuple> listFuncionarios = repository.getPessoasToAddProjeto(idProjeto);
		List<MembrosResponse> listMembros = getListDTO(listFuncionarios);
		return listMembros;
	}
	
	 private List<MembrosResponse> getListDTO(List<Tuple> listTuple) {
	        List<MembrosResponse> listDto = new ArrayList<>();
	        if (listTuple != null) {
	            for (Tuple tupla : listTuple) {
	            	MembrosResponse objDTO = new MembrosResponse();
	                objDTO.setIdPessoa((Long) tupla.get("idPessoa"));
	                objDTO.setNome(tupla.get("nome").toString());
	                objDTO.setCargo(tupla.get("cargo").toString());
	                objDTO.setGerente(tupla.get("gerente",boolean.class) ? "SIM" : "NÃO");
	                listDto.add(objDTO);
	            }
	        }
	        return listDto;
	 }

}
