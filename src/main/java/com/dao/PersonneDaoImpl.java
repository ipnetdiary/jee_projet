package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.javabeins.Personne;


public class PersonneDaoImpl implements PersonneDao {

	DaoConfig daoConfig;

	public PersonneDaoImpl(DaoConfig daoConfig) {
		this.daoConfig = daoConfig;
	}

	@Override
	public List<Personne> lister() {
		// TODO Auto-generated method stub
		Connection con = null; 
		 Statement statement = null;
	     ResultSet resultat = null;
	     
	     List<Personne> personnes = new ArrayList<Personne>();
	     
	        try {
	        	
	        	con = this.daoConfig.getConnection();
	        	
	            statement = con.createStatement();
	            resultat = statement.executeQuery("SELECT * FROM personne;");

	            while (resultat.next()) {
	                String nom = resultat.getString("nom");
	                String prenom = resultat.getString("prenom");
	                int salaire = resultat.getInt("salaire");
	           
	                Personne personne = new Personne(nom,prenom,salaire);
	                personnes.add(personne);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return personnes;
	}

	@Override
	public void ajouter(Personne p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifier(Personne p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimer() {
		// TODO Auto-generated method stub
		
	}

	
}
