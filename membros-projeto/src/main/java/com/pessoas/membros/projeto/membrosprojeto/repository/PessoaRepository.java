package com.pessoas.membros.projeto.membrosprojeto.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.pessoas.membros.projeto.membrosprojeto.entity.PessoaEntity;

import jakarta.persistence.Tuple;


@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Long>{

	
	@Query("SELECT pessoa.id as idPessoa ,pessoa.nome as nome, pessoa.gerente as gerente, cargo.nome as cargo FROM PessoaEntity pessoa LEFT JOIN CargoEntity cargo on pessoa.id = cargo.pessoa.id WHERE pessoa.funcionario=true and cargo.projeto.id=:idProjeto")
    List<Tuple> getPessoasToAddProjeto(long idProjeto);
}
