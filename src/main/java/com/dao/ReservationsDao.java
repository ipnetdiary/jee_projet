package com.dao;
import java.util.List;

import com.javabeins.*;
public interface ReservationsDao {
	List<Reservation> lister();
	void ajouter(Reservation resv);
	void modifier(Reservation resv,int id);
	void supprimer(int id);
}
