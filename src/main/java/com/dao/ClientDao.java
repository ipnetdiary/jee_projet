package com.dao;
import java.util.List;

import com.javabeins.*;
public interface ClientDao {
	List<Client> lister();
	void ajouter(Client cl);
	void modifier(Client cl,int id);
	void supprimer(int id);
}
