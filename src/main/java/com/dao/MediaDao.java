package com.dao;

import java.util.List;

import com.javabeins.Media;

public interface MediaDao {
	List<Media> lister();
	void ajouter(Media media);
	void modifier(Media media,int id);
	void supprimer(int id);

}
