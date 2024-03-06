package com.pessoas.membros.projeto.membrosprojeto.dto;

import lombok.Data;


public class ResponseDTO {
    private String status;// ok or error
    private String message;// error description
    private Object body;// in case of success
    
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getBody() {
		return body;
	}
	public void setBody(Object body) {
		this.body = body;
	}
    
    
}


