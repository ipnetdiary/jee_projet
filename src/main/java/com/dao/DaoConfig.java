package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DaoConfig {
		
	    private String url;	
	    private String username;
	    private String password;
	    
	
	    
	    public DaoConfig(String url, String username, String password) {
			this.url = url;
			this.username = username;
			this.password = password;
		}

	
	
		public static DaoConfig getInstance() throws SQLException, ClassNotFoundException {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/hotel";
			String username = "root";
			String password = "";
			DaoConfig daoConfig = new DaoConfig(url,username,password);
			return daoConfig;
		}
		
		public Connection getConnection() {
			Connection con = null;
			try {
				con = DriverManager.getConnection(url,username,password);
			return con;
			}catch(SQLException e) {
			}
			return con;
			
		}
		
		
		public AdminsDaoImpl getAdminsDao() {
			AdminsDaoImpl adminDaoImp  =  new AdminsDaoImpl(this);
			 return adminDaoImp;
		}
		public ClientsDaoImpl getClientDao() {
			ClientsDaoImpl clientDaoImp  =  new ClientsDaoImpl(this);
			 return clientDaoImp;
		}
		public ChambreDaoImpl getChambreDao() {
			ChambreDaoImpl chambreDaoImp  =  new ChambreDaoImpl(this);
			 return chambreDaoImp;
		}
		
		public ReservationsDaoImpl getChambreDao() {
			ReservationsDaoImpl reservationsDaoImp  =  new ReservationsDaoImpl(this);
			 return reservationsDaoImp;
		}
}
