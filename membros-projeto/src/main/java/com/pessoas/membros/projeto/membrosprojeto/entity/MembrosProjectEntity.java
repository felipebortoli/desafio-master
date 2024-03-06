package com.pessoas.membros.projeto.membrosprojeto.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Entity
@Table(name = "membros")
public class MembrosProjectEntity {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idprojeto;
	
	@ManyToOne
	private PessoaEntity idPessoa;
	
	public Long getIdprojeto() {
		return idprojeto;
	}

	public void setIdprojeto(Long idprojeto) {
		this.idprojeto = idprojeto;
	}

	public PessoaEntity getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(PessoaEntity idPessoa) {
		this.idPessoa = idPessoa;
	}

			
}


