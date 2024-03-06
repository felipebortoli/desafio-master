package br.com.biblioteca.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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

	private String cargo;

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

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
}


