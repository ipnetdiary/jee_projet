package com.dao;

import com.javabeins.Personne;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;

public class ClientsDaoImpl implements ClientDao {

	DaoConfig daoConfig;

	public ClientsDaoImpl(DaoConfig daoConfig) {
		this.daoConfig = daoConfig;
	}

	@Override
	public List<Client> lister() {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement statement = null;
		ResultSet resultat = null;

		List<Client> clients = new ArrayList<Client>();

		try {

			con = this.daoConfig.getConnection();

			statement = con.createStatement();
			resultat = statement.executeQuery("SELECT * FROM client;");

			while (resultat.next()) {
				int id = resultat.getString("id");
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
		Statement stmt = con.createStatement();
		String query = "INSERT INTO `client`" + "( `nom`, `prenom`, "
				+ "`cin`, `tel`, `email`) " 
		+ "VALUES( " 
				+ "'" +cl.getNom() + "',"
				+ "'" +cl.getPrenom() + "'," 
				+ "'" +cl.getCin() + "'," 
				+ "'" +cl.getTelephone() + "'," 
				+ "'" + cl.getEmail() + "')";
		System.out.print(query);

		int nbUpdated = stmt.executeUpdate(query);
		return nbUpdated > 0;
	}

	@Override
	public void modifier(Client cl, int id) {
		// TODO Auto-generated method stub
		Statement stmt = con.createStatement();
        String query = " UPDATE client "
                + " SET nom='" + cl.getNom()
                + "', prenom='" + cl.getPrenom()
                + "', cin='" + cl.getCin()
                + "', tel='" + cl.getTelephone()
                + "', email='" + cl.getEmail()
                + "' WHERE id = " + id + " ";

		int nbUpdated = stmt.executeUpdate(query);
		return nbUpdated > 0;
	}

	@Override
	public void supprimer(int id) {
		// TODO Auto-generated method stub
		Statement stmt = con.createStatement();

		String query = "DELETE FROM client WHERE id = '" + id + "' ";

		int nbUpdated = stmt.executeUpdate(query);
		return nbUpdated > 0;
	}
}
