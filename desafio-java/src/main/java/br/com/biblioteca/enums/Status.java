package br.com.biblioteca.enums;

public enum Status {
	 EM_ANALISE("Em Analise"),
	 ANALISE_REALIZADA("Analise Realizada"),
	 ANALISE_APROVADA("Analise Aprovada"),
	 INICIADO("Iniciado"),
	 PLANEJADO("Planejado"),
	 EM_ANDAMENTO("Em Andamento"),
	 ENCERRADO("Encerrado"),
	 CANCELADO("Cancelado");

	private String text;
	
	Status(String string) {
		text = string;
	}
	
	
	public String getText() {
		return text;
	}
	
	public static Status getStatus(String text) {
		for(Status status : Status.values()) {
			if(status.getText().equals(text)) {
				return status;
			}
		}
		return null;
	}
}
