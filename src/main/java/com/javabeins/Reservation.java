package com.javabeins;
import java.util.Date;
public class Reservation {
	private int id;
	
	private int id_client ;
	private int id_chambre;
	private String date_arriver ;
	private String date_depart;
	private String mode_payement;
	private int durre;
	
	public Reservation(int id_client, int id_chambre, String date_arriver,String date_depart,String mode_payement, int durre) {
		super();
		this.id_client =id_client;
		this.id_chambre=id_chambre;
		this.date_arriver= date_arriver;
		this.date_depart=date_depart;
		this.mode_payement= mode_payement;
		this.durre = durre;
		

}
	public Reservation(int id,int id_client, int id_chambre, String date_arriver,String date_depart,String mode_payement, int durre) {
		super();
		this.id =id;
		this.id_client =id_client;
		this.id_chambre=id_chambre;
		this.date_arriver= date_arriver;
		this.date_depart=date_depart;
		this.mode_payement= mode_payement;
		this.durre = durre;
		
}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_client() {
		return id_client;
	}
	public void setId_client(int id_client) {
		this.id_client = id_client;
	}
	public int getId_chambre() {
		return id_chambre;
	}
	public void setId_chambre(int id_chambre) {
		this.id_chambre = id_chambre;
	}
	public String getDate_arriver() {
		return date_arriver;
	}
	public void setDate_arriver(String date_arriver) {
		this.date_arriver = date_arriver;
	}
	public String getDate_depart() {
		return date_depart;
	}
	public void setDate_depart(String date_depart) {
		this.date_depart = date_depart;
	}
	public String getMode_payement() {
		return mode_payement;
	}
	public void setMode_payement(String mode_payement) {
		this.mode_payement = mode_payement;
	}
	public int getDurre() {
		return durre;
	}
	public void setDurre(int durre) {
		this.durre = durre;
	}
	
	
}
