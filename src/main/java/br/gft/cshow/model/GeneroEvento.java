package br.gft.cshow.model;

public enum GeneroEvento {
	
	ROCK("Rock"),
	SERTANEJO("Sertanejo"),
	PAGODE("Pagode"),
	SAMBA("Samba");
	
	private String descricao;

	public String getDescricao() {
		return descricao;
	}


	GeneroEvento(String descricao){
		this.descricao = descricao;
	}
	
	
}
