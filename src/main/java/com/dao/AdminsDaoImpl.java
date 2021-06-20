package com.dao;

import com.javabeins.Personne;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;

public class AdminsDaoImpl  implements AdminsDao {
	DaoConfig daoConfig;

	public AdminsDaoImpl(DaoConfig daoConfig) {
		this.daoConfig = daoConfig;
	}

	@Override
	public List<Admin> lister() {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement statement = null;
		ResultSet resultat = null;

		List<Admin> admins = new ArrayList<Admin>();

		try {

			con = this.daoConfig.getConnection();

			statement = con.createStatement();
			resultat = statement.executeQuery("SELECT * FROM admins;");

			while (resultat.next()) {
				int id = resultat.getString("id");
				String nom = resultat.getString("username");
				String prenom = resultat.getString("password");

				Admin admin = new Admin(id, username, password);
				admins.add(admin);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return admins;
	}

	@Override
	public void ajouter(Admin adm) {
		// TODO Auto-generated method stub
		Statement stmt = con.createStatement();
		String query = "INSERT INTO `admins`" + "( `username`, `password`) " 
		+ "VALUES( " 
				+ "'" +adm.getUsername() + "',"
				+ "'" + adm.getPassword() + "')";
		System.out.print(query);

		int nbUpdated = stmt.executeUpdate(query);
		return nbUpdated > 0;
	}

	@Override
	public void modifier(Admin adm, int id) {
		// TODO Auto-generated method stub
		Statement stmt = con.createStatement();
        String query = " UPDATE client "
                + " SET username='" + adm.getUsername()
                + "', password='" + adm.getPassword()
                + "' WHERE id = " + id + " ";

		int nbUpdated = stmt.executeUpdate(query);
		return nbUpdated > 0;
	}

	@Override
	public void supprimer(int id) {
		// TODO Auto-generated method stub
		Statement stmt = con.createStatement();

		String query = "DELETE FROM admins WHERE id = '" + id + "' ";

		int nbUpdated = stmt.executeUpdate(query);
		return nbUpdated > 0;
	}
}
