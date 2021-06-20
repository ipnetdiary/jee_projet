package com.dao;

public interface AdminsDao {
	List<Admin> lister();
	void ajouter(Admin adm);
	void modifier(Admin adm,int id);
	void supprimer(int id);
}
