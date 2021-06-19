package com.dao;
import java.util.List;

import com.javabeins.*;


public interface PersonneDao {
	List<Personne> lister();
	void ajouter(Personne p);
	void modifier(Personne p);
	void supprimer();
}
