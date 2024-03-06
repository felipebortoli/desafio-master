package com.pessoas.membros.projeto.membrosprojeto.entity;


import lombok.EqualsAndHashCode;

import java.time.LocalDate;

import enums.ClassificacaoRisco;
import enums.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity(name = "projeto")
@Table(name = "projeto")
public class ProjetoEntity {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	private LocalDate data_inicio;
	
	private LocalDate data_previsao_fim;
	
	private LocalDate data_fim;
	
	private String descricao;
	
	@Enumerated(EnumType.STRING)	
	private ClassificacaoRisco classificacao_risco;
	
	@Enumerated(EnumType.STRING)	
	private Status status;
	
	private float orcamento;
	
	@ManyToOne
	private PessoaEntity gerente;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getData_inicio() {
		return data_inicio;
	}

	public void setData_inicio(LocalDate data_inicio) {
		this.data_inicio = data_inicio;
	}

	public LocalDate getData_previsao_fim() {
		return data_previsao_fim;
	}

	public void setData_previsao_fim(LocalDate data_previsao_fim) {
		this.data_previsao_fim = data_previsao_fim;
	}

	public LocalDate getData_fim() {
		return data_fim;
	}

	public void setData_fim(LocalDate data_fim) {
		this.data_fim = data_fim;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public ClassificacaoRisco getClassificacaoRisco() {
		return classificacao_risco;
	}

	public void setClassificacaoRisco(ClassificacaoRisco classificacaoRisco) {
		this.classificacao_risco = classificacaoRisco;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public float getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(float orcamento) {
		this.orcamento = orcamento;
	}

	public PessoaEntity getGerente() {
		return gerente;
	}

	public void setGerente(PessoaEntity gerente) {
		this.gerente = gerente;
	}
	
	
	
}
