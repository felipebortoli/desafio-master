package br.com.biblioteca.dto;

public class MembrosDTO {
	
	private long idProjeto;
	private long idPessoa;
	private String nome;
	private String cargo;
	private String gerente;
	

	public long getIdProjeto() {
		return idProjeto;
	}
	public void setIdProjeto(long idProjeto) {
		this.idProjeto = idProjeto;
	}
	public long getIdPessoa() {
		return idPessoa;
	}
	public void setIdPessoa(long idPessoa) {
		this.idPessoa = idPessoa;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getGerente() {
		return gerente;
	}
	public void setGerente(String gerente) {
		this.gerente = gerente;
	}
	
	

}
