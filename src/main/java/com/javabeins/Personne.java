package com.javabeins;

public class Personne {

	private String nom;
	private String prenom;
	private int salaire;
	
	
	public Personne(String nom, String prenom, int salaire) {
		this.nom = nom;
		this.prenom = prenom;
		this.salaire = salaire;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getSalaire() {
		return salaire;
	}
	public void setSalaire(int salaire) {
		this.salaire = salaire;
	}
}
