package com.dao;

import java.util.List;


import com.javabeins.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



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
				int id = resultat.getInt("id");
				String username = resultat.getString("username");
				String password = resultat.getString("password");

				Admin admin = new Admin(id, username, password);
				admins.add(admin);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return admins;
	}

	@Override
	public void ajouter(Admin adm){
		Connection con = null;
		Statement stmt = null;
		try {
			con = this.daoConfig.getConnection();
		// TODO Auto-generated method stub
		stmt = con.createStatement();
		String query = "INSERT INTO `admins`" + "( `username`, `password`) " 
		+ "VALUES( " 
				+ "'" +adm.getUsername() + "',"
				+ "'" + adm.getPassword() + "')";
		System.out.print(query);

		stmt.executeUpdate(query);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void modifier(Admin adm, int id) {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement stmt = null;
		try {
			
			con = this.daoConfig.getConnection();
			stmt = con.createStatement();
	        String query = " UPDATE client "
	                + " SET username='" + adm.getUsername()
	                + "', password='" + adm.getPassword()
	                + "' WHERE id = " + id + " ";

			 stmt.executeUpdate(query);
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	
	}

	@Override
	public void supprimer(int id) {
		Connection con = null;
		Statement stmt = null;
		try {
		con = this.daoConfig.getConnection();
		
		// TODO Auto-generated method stub
		stmt = con.createStatement();

		String query = "DELETE FROM admins WHERE id = '" + id + "' ";

		stmt.executeUpdate(query);
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
