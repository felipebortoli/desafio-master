package com.pessoas.membros.projeto.membrosprojeto.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pessoas.membros.projeto.membrosprojeto.entity.CargoEntity;


@Repository
public interface CargoRepository extends JpaRepository<CargoEntity, Long>{

	@Query("SELECT cargo FROM CargoEntity cargo  Where cargo.projeto.id=:idProjeto and cargo.pessoa.id=:idPessoa")
	Optional<CargoEntity> getByidPessoaAndIdProjeto(long idPessoa, long idProjeto);
}
