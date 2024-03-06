package com.pessoas.membros.projeto.membrosprojeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pessoas.membros.projeto.membrosprojeto.entity.ProjetoEntity;

@Repository
public interface ProjetoRepository extends JpaRepository<ProjetoEntity, Long>{

}
