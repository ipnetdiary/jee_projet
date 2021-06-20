package com.dao;

public interface ClientDao {
	List<Client> lister();
	void ajouter(Client cl);
	void modifier(Client cl,int id);
	void supprimer(int id);
}
