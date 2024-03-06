package br.com.biblioteca.dto.request;

public class MembrosRequest {
	private long idProjeto;
	private long idPessoa;
	private String cargo;
	
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
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	

}
