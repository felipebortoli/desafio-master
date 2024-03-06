package com.pessoas.membros.projeto.membrosprojeto.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.pessoas.membros.projeto.membrosprojeto.entity.MembrosProjectEntity;



@Repository
public interface MembrosRepository extends JpaRepository<MembrosProjectEntity, Long>{
	

}
