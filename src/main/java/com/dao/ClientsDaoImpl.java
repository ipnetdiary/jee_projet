package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.javabeins.Client;
import com.javabeins.Personne;

public class ClientsDaoImpl implements ClientDao {

	DaoConfig daoConfig;
	private Connection con;
	public ClientsDaoImpl(DaoConfig daoConfig) {
		this.daoConfig = daoConfig;
	}

	@Override
	public List<Client> lister() {
		// TODO Auto-generated method stub

		Statement statement = null;
		ResultSet resultat = null;

		List<Client> clients = new ArrayList<Client>();

		try {

			con = this.daoConfig.getConnection();

			statement = con.createStatement();
			resultat = statement.executeQuery("SELECT * FROM client;");

			while (resultat.next()) {
				int id = resultat.getInt("id");
				String nom = resultat.getString("nom");
				String prenom = resultat.getString("prenom");
				String cin = resultat.getString("cin");
				String tel = resultat.getString("tel");
				String email = resultat.getString("email");

				Client client = new Client(id, nom, prenom, cin, tel, email);
				clients.add(client);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clients;
	}

	@Override
	public void ajouter(Client cl) {
		// TODO Auto-generated method stub
		Statement stmt;
		try {
			stmt = con.createStatement();
	
		String query = "INSERT INTO `client`" + "( `nom`, `prenom`, "
				+ "`cin`, `tel`, `email`) " 
		+ "VALUES( " 
				+ "'" +cl.getNom() + "',"
				+ "'" +cl.getPrenom() + "'," 
				+ "'" +cl.getCin() + "'," 
				+ "'" +cl.getTel() + "'," 
				+ "'" + cl.getEmail() + "')";
		System.out.print(query);

		 stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void modifier(Client cl, int id) {
		// TODO Auto-generated method stub
		Statement stmt;
		try {
			stmt = con.createStatement();
			 String query = " UPDATE client "
		                + " SET nom='" + cl.getNom()
		                + "', prenom='" + cl.getPrenom()
		                + "', cin='" + cl.getCin()
		                + "', tel='" + cl.getTel()
		                + "', email='" + cl.getEmail()
		                + "' WHERE id = " + id + " ";

		stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
		
	}

	@Override
	public void supprimer(int id) {
		// TODO Auto-generated method stub
		try {
		Statement stmt = con.createStatement();
		
		String query = "DELETE FROM client WHERE id = '" + id + "' ";

		stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
