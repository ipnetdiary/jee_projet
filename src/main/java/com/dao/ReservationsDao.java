package com.dao;

public interface ReservationsDao {
	List<Reservation> lister();
	void ajouter(Reservation resv);
	void modifier(Reservation resv,int id);
	void supprimer(int id);
}
