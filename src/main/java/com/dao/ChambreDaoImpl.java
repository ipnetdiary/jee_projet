package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.javabeins.Chambre;
import com.javabeins.Personne;

public class ChambreDaoImpl implements ChambreDao {

	DaoConfig daoConfig;
	private Connection con;

	public ChambreDaoImpl(DaoConfig daoConfig) {
		this.daoConfig = daoConfig;
	}

	@Override
	public List<Chambre> lister() {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement statement = null;
		ResultSet resultat = null;

		List<Chambre> chambres = new ArrayList<Chambre>();

		try {

			con = this.daoConfig.getConnection();

			statement = con.createStatement();
			resultat = statement.executeQuery("SELECT * FROM chambre;");

			while (resultat.next()) {
				int id = resultat.getInt("id");
				int nbr_lit = resultat.getInt("nbr_lit");
				int etage = resultat.getInt("etage");
				int n_chambre = resultat.getInt("n_chambre");
				String cin = resultat.getString("cin");
				int game = resultat.getInt("game");
				String telephone = resultat.getString("telephone");
				int is_free = resultat.getInt("is_free");
				int prix = resultat.getInt("prix");

				Chambre chambre = new Chambre(id, nbr_lit, etage, n_chambre, cin, game, telephone, is_free, prix);
				chambres.add(chambre);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return chambres;
	}

	@Override
	public void ajouter(Chambre ch) {
		// TODO Auto-generated method stub
		
		con = null;
		Statement stmt = null;
		try {
		stmt = con.createStatement();
		String query = "INSERT INTO `chambre`" + "( `nbr_lit`, `etage`, "
				+ "`n_chambre`, `game`, `telephone`, `is_free`, `prix`) " 
		+ "VALUES( " 
				+ "'" +ch.getNbr_lit() + "',"
				+ "'" +ch.getEtage() + "'," 
				+ "'" +ch.getN_chambre() + "'," 
				+ "'" +ch.getGame() + "'," 
				+ "'" +ch.getTelephone() + "',"
				+ "'" +ch.isIs_free() + "',"
				+ "'" + ch.getPrix() + "')";
		System.out.print(query);

		 stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void modifier(Chambre ch, int id) {
		con = null;
		Statement stmt = null;
		try {
		// TODO Auto-generated method stub
		stmt = con.createStatement();
        String query = " UPDATE chambre "
                + " SET nbr_lit='" + ch.getNbr_lit()
                + "', etage='" + ch.getEtage()
                + "', n_chambre='" + ch.getN_chambre()
                + "', game='" + ch.getGame()
                + "', telephone='" + ch.getTelephone()
                + "', is_free='" + ch.isIs_free()
                + "', prix='" + ch.getPrix()
                + "' WHERE id = " + id + " ";

		stmt.executeUpdate(query);
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void supprimer(int id) {
		// TODO Auto-generated method stub
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String query = "DELETE FROM chambre WHERE id = '" + id + "' ";

			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	
	}

	

}
