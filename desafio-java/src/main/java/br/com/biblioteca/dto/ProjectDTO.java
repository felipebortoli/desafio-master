package br.com.biblioteca.dto;

import java.util.List;
import java.util.Map;

import br.com.biblioteca.enums.ClassificacaoRisco;
import br.com.biblioteca.enums.Status;



public class ProjectDTO {
	
	private Long id;
	
	private String nome;
	
	private String data_inicio;
	
	private String data_previsao_fim;
	
	private String data_fim;
	
	private String descricao;
	
	private ClassificacaoRisco classificacaoRisco;
	

	private Status status;
	
	private float orcamento;
	
	private List<GerenteDTO> gerentes;
	
	private String gerente;
	
	private long gerenteProjetoId;
	
	
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

	public String getData_inicio() {
		return data_inicio;
	}

	public void setData_inicio(String data_inicio) {
		this.data_inicio = data_inicio;
	}

	public String getData_previsao_fim() {
		return data_previsao_fim;
	}

	public void setData_previsao_fim(String data_previsao_fim) {
		this.data_previsao_fim = data_previsao_fim;
	}

	public String getData_fim() {
		return data_fim;
	}

	public void setData_fim(String data_fim) {
		this.data_fim = data_fim;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public ClassificacaoRisco getClassificacaoRisco() {
		return classificacaoRisco;
	}

	public void setClassificacaoRisco(ClassificacaoRisco classificacaoRisco) {
		this.classificacaoRisco = classificacaoRisco;
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

	public List<GerenteDTO> getGerentes() {
		return gerentes;
	}

	public void setGerentes(List<GerenteDTO> gerentes) {
		this.gerentes = gerentes;
	}

	public String getGerente() {
		return gerente;
	}

	public void setGerente(String gerente) {
		this.gerente = gerente;
	}

	public long getGerenteProjetoId() {
		return gerenteProjetoId;
	}

	public void setGerenteProjetoId(long gerenteProjetoId) {
		this.gerenteProjetoId = gerenteProjetoId;
	}

	
}
