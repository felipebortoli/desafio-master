package br.com.biblioteca.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.biblioteca.model.PessoaEntity;

@Repository
public class PessoaRepositoryImpl implements PessoaRepository{
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<PessoaEntity> listByGerente() {
		 TypedQuery<PessoaEntity> q =  entityManager.createQuery("SELECT p FROM pessoa p WHERE p.gerente = true and p.funcionario = true", PessoaEntity.class);
		 return q.getResultList();
	}

	@Override
	public PessoaEntity getById(long id) {
		return entityManager.find(PessoaEntity.class, id);
	}

	@Override
	public List<PessoaEntity> listByFuncionario() {
		TypedQuery<PessoaEntity> q =  entityManager.createQuery("SELECT p FROM pessoa p WHERE p.funcionario = true", PessoaEntity.class);
		 return q.getResultList();
	}

}
