package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.javabeins.Personne;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;

public class ChambreDaoImpl implements ChambreDao {

	DaoConfig daoConfig;

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
				int game = resultat.getInt("game");
				String telephone = resultat.getString("telephone");
				int is_free = resultat.getInt("is_free");
				int prix = resultat.getInt("prix");

				Chambre chambre = new Chambre(id, nbr_lit, etage, n_chambre, game, telephone, is_free, prix);
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
		Statement stmt = con.createStatement();
		String query = "INSERT INTO `chambre`" + "( `nbr_lit`, `etage`, "
				+ "`n_chambre`, `game`, `telephone`, `is_free`, `prix`) " 
		+ "VALUES( " 
				+ "'" +ch.getNbrLit() + "',"
				+ "'" +ch.getEtage() + "'," 
				+ "'" +ch.getNChambre() + "'," 
				+ "'" +ch.getGame() + "'," 
				+ "'" +ch.getTelephone() + "',"
				+ "'" +ch.getIsFree() + "',"
				+ "'" + ch.getPrix() + "')";
		System.out.print(query);

		int nbUpdated = stmt.executeUpdate(query);
		return nbUpdated > 0;
	}

	@Override
	public void modifier(Chambre ch, int id) {
		// TODO Auto-generated method stub
		Statement stmt = con.createStatement();
        String query = " UPDATE chambre "
                + " SET nbr_lit='" + ch.getNbrLit()
                + "', etage='" + ch.getEtage()
                + "', n_chambre='" + ch.getNChambre()
                + "', game='" + ch.getGame()
                + "', telephone='" + ch.getTelephone()
                + "', is_free='" + ch.getKMParcouru()
                + "', prix='" + ch.getPrix()
                + "' WHERE id = " + id + " ";

		int nbUpdated = stmt.executeUpdate(query);
		return nbUpdated > 0;
	}

	@Override
	public void supprimer(int id) {
		// TODO Auto-generated method stub
		Statement stmt = con.createStatement();

		String query = "DELETE FROM chambre WHERE id = '" + id + "' ";

		int nbUpdated = stmt.executeUpdate(query);
		return nbUpdated > 0;
	}

}
