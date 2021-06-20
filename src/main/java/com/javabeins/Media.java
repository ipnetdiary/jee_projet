package com.javabeins;

public class Media extends Chambre {
	private int id;
	private String url;
	private String id_chambre;
	
	public String getId_chambre() {
		return id_chambre;
	}
	public void setId_chambre(String id_chambre) {
		this.id_chambre = id_chambre;
	}
	public Media() {
		super();
	}
	public Media(String url) {
		super();
		this.url = url;
		
		
	}
	public Media(int id,String url ) {
		super();
		this.id = id;
		this.url = url;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	

}
