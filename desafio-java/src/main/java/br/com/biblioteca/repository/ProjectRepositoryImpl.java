package br.com.biblioteca.repository;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import br.com.biblioteca.model.ProjetoEntity;

@Repository
public class ProjectRepositoryImpl implements ProjectRepository{

	@Autowired
	private EntityManager entityManager;

     
	
	@Override
	public List<ProjetoEntity> list() {
	   TypedQuery<ProjetoEntity> q = entityManager.createQuery("SELECT p FROM projeto p", ProjetoEntity.class);
	   return q.getResultList();
	}

	@Override
	public ProjetoEntity getProjectById(long id) {
		return entityManager.find(ProjetoEntity.class, id);
	}

	@Override
	public void delete(ProjetoEntity ProjetoEntity) {
		if (entityManager.contains(ProjetoEntity)) {
			entityManager.remove(ProjetoEntity);
        } else {
        	entityManager.merge(ProjetoEntity);
        }
		
	}

	@Override
	public ProjetoEntity save(ProjetoEntity ProjetoEntity) {
		if (ProjetoEntity.getId() == null) {
			entityManager.persist(ProjetoEntity);
			
        } else {
        	ProjetoEntity = (ProjetoEntity) entityManager.merge(ProjetoEntity);
        }
        return ProjetoEntity;
		
	}

	@Override
	public List<ProjetoEntity> listFuncionarios() {
		TypedQuery<ProjetoEntity> q = entityManager.createQuery("SELECT p FROM projeto p WHERE p.funcionario = true", ProjetoEntity.class);
		return q.getResultList();
	}
	


}
