package com.dao;

import com.javabeins.Personne;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;

public class ReservationsDaoImpl {

	DaoConfig daoConfig;

	public ReservationsDaoImpl(DaoConfig daoConfig) {
		this.daoConfig = daoConfig;
	}

	@Override
	public List<Reservation> lister() {
		// TODO Auto-generated method stub
		Connection con = null;
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
				String durre = resultat.getString("durre");

				Reservation reservation = new Reservation(id,id_chambre,id_client,date_arriver,date_depart,mode_payement,durre);
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
		Statement stmt = con.createStatement();
		String query = "INSERT INTO `reservations`" + "( `id_chambre`, `id_client`, "
				+ "`date_arriver`, `date_depart`, `mode_payement`, `durre`) " 
		+ "VALUES( " 
				+ "'" +resv.getIdChambre() + "',"
				+ "'" +resv.getIdClient() + "'," 
				+ "'" +resv.getDateArriver() + "'," 
				+ "'" +resv.getDateDepart() + "'," 
				+ "'" +resv.getModePayement() + "',"
				+ "'" + resv.getDurre() + "')";
		System.out.print(query);

		int nbUpdated = stmt.executeUpdate(query);
		return nbUpdated > 0;
	}

	@Override
	public void modifier(Reservation resv, int id) {
		// TODO Auto-generated method stub
		Statement stmt = con.createStatement();
        String query = " UPDATE reservations "
                + " SET id_chambre='" + resv.getIdChambre()
                + "', id_client='" + resv.getIdClient()
                + "', date_arriver='" + resv.getDateArriver()
                + "', date_depart='" + resv.getDateDepart()
                + "', mode_payement='" + resv.getModePayement()
                + "', durre='" + resv.getDurre()
                + "' WHERE id = " + id + " ";

		int nbUpdated = stmt.executeUpdate(query);
		return nbUpdated > 0;
	}

	@Override
	public void supprimer(int id) {
		// TODO Auto-generated method stub
		Statement stmt = con.createStatement();

		String query = "DELETE FROM reservations WHERE id = '" + id + "' ";

		int nbUpdated = stmt.executeUpdate(query);
		return nbUpdated > 0;
	}
}
