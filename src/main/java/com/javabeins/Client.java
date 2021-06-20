package com.javabeins;

import java.util.*;
public class Client {

	private int id;
	private String nom;
	private String prenom ;
	private String cin;
	private String tel;
	private String email;
	
	public Client() {
		super();
	}
	public Client(String nom, String prenom, String cin, String tel, String email) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.cin = cin;
		this.tel = tel;
		this.email = email;
		
	}
	public Client(int id, String nom, String prenom, String cin, String tel, String email) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.cin = cin;
		this.tel = tel;
		this.email = email;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
