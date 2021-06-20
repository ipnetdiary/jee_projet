package com.javabeins;
import java.util.*;
import java.util.Date;

public class Chambre {
	private int id;
	private int nbr_lit;
	private int etage ;
	private int n_chambre;
	private String game;
	private String telephone;
	private boolean is_free;
	private int prix;

	public Chambre() {
		super();
	}
	public Chambre( String nbr_lit, String etage, Strin n_chambre, String cin, String game, Date telephone,boolean is_free,int prix) {
		super();
		this.nbr_lit = nbr_lit;
		this.etage= etage;
		this.n_chambre= n_chambre;
		this.game=game;
		this.telephone = telephone;
		this.is_free = is_free;
	public Chambre(int id, String nbr_lit, String etage, Strin n_chambre, String cin, String game, Date telephone,boolean is_free,int prix) {
		super();
		this.id = id;
		this.nbr_lit = nbr_lit;
		this.etage= etage;
		this.n_chambre= n_chambre;
		this.game=game;
		this.telephone = telephone;
		this.is_free = is_free;
		
}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNbr_lit() {
		return nbr_lit;
	}
	public void setNbr_lit(int nbr_lit) {
		this.nbr_lit = nbr_lit;
	}
	public int getEtage() {
		return etage;
	}
	public void setEtage(int etage) {
		this.etage = etage;
	}
	public int getN_chambre() {
		return n_chambre;
	}
	public void setN_chambre(int n_chambre) {
		this.n_chambre = n_chambre;
	}
	public String getGame() {
		return game;
	}
	public void setGame(String game) {
		this.game = game;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public boolean isIs_free() {
		return is_free;
	}
	public void setIs_free(boolean is_free) {
		this.is_free = is_free;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
