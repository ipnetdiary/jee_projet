package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.javabeins.Personne;
import com.javabeins.Reservation;

public class ReservationsDaoImpl implements ReservationsDao {

	DaoConfig daoConfig;
	Connection con = null;

	public ReservationsDaoImpl(DaoConfig daoConfig) {
		this.daoConfig = daoConfig;
	}

	@Override
	public List<Reservation> lister() {
		// TODO Auto-generated method stub
		
		Statement statement = null;
		ResultSet resultat = null;

		List<Reservation> reservations = new ArrayList<Reservation>();

		try {

			con = this.daoConfig.getConnection();

			statement = con.createStatement();
			resultat = statement.executeQuery("SELECT * FROM reservations;");

			while (resultat.next()) {
				int id = resultat.getInt("id");
				int id_chambre = resultat.getInt("id_chambre");
				int id_client = resultat.getInt("id_client");
				String date_arriver = resultat.getString("date_arriver");
				String date_depart = resultat.getString("date_depart");
				String mode_payement = resultat.getString("mode_payement");
				int durre = resultat.getInt("durre");

				Reservation reservation = new Reservation(id,id_client,id_chambre,date_arriver,date_depart,mode_payement,durre);
				reservations.add(reservation);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reservations;
	}

	@Override
	public void ajouter(Reservation resv) {
		// TODO Auto-generated method stub
		Statement stmt;
		try {
			stmt = con.createStatement();
	
		String query = "INSERT INTO `reservations`" + "( `id_chambre`, `id_client`, "
				+ "`date_arriver`, `date_depart`, `mode_payement`, `durre`) " 
		+ "VALUES( " 
				+ "'" +resv.getId_chambre() + "',"
				+ "'" +resv.getId_client() + "'," 
				+ "'" +resv.getDate_arriver() + "'," 
				+ "'" +resv.getDate_depart() + "'," 
				+ "'" +resv.getMode_payement() + "',"
				+ "'" + resv.getDurre() + "')";
		System.out.print(query);

		stmt.executeUpdate(query);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void modifier(Reservation resv, int id) {
		// TODO Auto-generated method stub
		try {
		Statement stmt = con.createStatement();
        String query = " UPDATE reservations "
                + " SET id_chambre='" + resv.getId_chambre()
                + "', id_client='" + resv.getId_client()
                + "', date_arriver='" + resv.getDate_arriver()
                + "', date_depart='" + resv.getDate_depart()
                + "', mode_payement='" + resv.getMode_payement()
                + "', durre='" + resv.getDurre()
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

		String query = "DELETE FROM reservations WHERE id = '" + id + "' ";

		stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
