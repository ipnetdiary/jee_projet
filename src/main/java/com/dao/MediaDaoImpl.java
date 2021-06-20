package com.dao;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.javabeins.Media;





public class MediaDaoImpl implements MediaDao {
	DaoConfig daoConfig;

	public MediaDaoImpl(DaoConfig daoConfig) {
		this.daoConfig = daoConfig;
	}

	@Override
	public List<Media> lister() {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement statement = null;
		ResultSet resultat = null;

		List<Media> medias = new ArrayList<Media>();

		 try {
	        	
	        	con = this.daoConfig.getConnection();
	        	
	            statement = con.createStatement();
	            resultat = statement.executeQuery("SELECT * FROM media;");

	            while (resultat.next()) {
	                String url = resultat.getString("url");
	             
	           
	                Media media = new Media(url);
	                medias.add(media);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return medias;
	}

	@Override
	public void ajouter(Media media) {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement statement = null;
		ResultSet resultat = null;
		 try {
	        	
	        	con = this.daoConfig.getConnection();
		Statement stmt = con.createStatement();
		String query = "INSERT INTO `media`" + "( `url`, `id_chambre`) " 
		+ "VALUES( " 
				+ "'" +media.getUrl() + "',"
				+ "'" + media.getId_chambre() + "')";
		
		 stmt.executeUpdate(query);
		
		 } catch (SQLException e) {
	            e.printStackTrace();

	}
	}
	@Override
	public void modifier(Media media, int id) {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement statement = null;
		ResultSet resultat = null;
		 try {
	        	
	        	con = this.daoConfig.getConnection();
		Statement stmt = con.createStatement();
		  String query = " UPDATE media "
	                + " SET url='" + media.getUrl()
	                + "', id_chambre='" + media.getId_chambre()
	               
	                + "' WHERE id = " + id + " ";
		  stmt.executeUpdate(query);
		
		 } catch (SQLException e) {
	            e.printStackTrace();

	}
	}

	

	@Override
	public void supprimer(int id) {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement statement = null;
		ResultSet resultat = null;
		 try {
	        	
	        	con = this.daoConfig.getConnection();
		
		Statement stmt = con.createStatement();

		String query = "DELETE FROM media WHERE id = '" + id + "' ";
		stmt.executeUpdate(query);
		 } catch (SQLException e) {
	            e.printStackTrace();

	}
	}}


