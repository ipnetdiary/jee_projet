package com.dao;
import java.util.List;

import com.javabeins.*;
public interface ChambreDao {
	List<Chambre> lister();
	void ajouter(Chambre ch);
	void modifier(Chambre ch,int id);
	void supprimer(int id);
}
