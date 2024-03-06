package br.com.biblioteca.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.biblioteca.dto.GerenteDTO;
import br.com.biblioteca.mapper.PessoaMapper;
import br.com.biblioteca.model.PessoaEntity;
import br.com.biblioteca.model.ProjetoEntity;
import br.com.biblioteca.repository.PessoaRepository;


@Service
@Transactional
public class PessoaServiceImpl implements IPessoaService{

	@Autowired
	private PessoaRepository pessoaRepository;
	
	private final PessoaMapper mapper = new PessoaMapper();
	
	@Override
	public List<GerenteDTO> listByGerente() {
		List<GerenteDTO> gerenteDTO = mapper.EntitytoDTOList(pessoaRepository.listByGerente());
		return gerenteDTO;
	}

	@Override
	public PessoaEntity getById(long id) {
		return pessoaRepository.getById(id);
	}

	@Override
	public List<PessoaEntity> listFuncionarios() {
		return pessoaRepository.listByFuncionario();
	}

}
