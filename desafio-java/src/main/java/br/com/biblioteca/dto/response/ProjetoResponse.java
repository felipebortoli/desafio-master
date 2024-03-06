package br.com.biblioteca.dto.response;


public class ProjetoResponse {

	private long id;
	
	private String nome;
	
	private String gerente;
	
	private String data_inicio;
	
	private String data_previsao_fim;
	
	private String data_fim;
	
	private String descricao;
	
	private String status;
	
	private float orcamento;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getGerente() {
		return gerente;
	}

	public void setGerente(String gerente) {
		this.gerente = gerente;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public float getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(float orcamento) {
		this.orcamento = orcamento;
	}
	
	
	
	
}
