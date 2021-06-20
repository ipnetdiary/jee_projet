package com.servlets;

import java.sql.SQLException;
import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.dao.ChambreDaoImpl;
import com.dao.DaoConfig;





public class AcceuilServlet extends HttpServlet {
	
	
	
	ChambreDaoImpl chambre;
	 public AcceuilServlet() {
	        super();
	        // TODO Auto-generated constructor stub
	    }
	public void init() throws ServletException {
        try {
        	
			DaoConfig daoConfig = DaoConfig.getInstance();
			
			//personnes = daoConfig.getPersonnesDao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		// TODO Auto-generated method stub
    		//response.getWriter().append("Served at: ").append(request.getContextPath());
    		 List<Chambre> personnesdb = new ArrayList<hambbre>();
    		 
    		 personnesdb = personnes.lister();
    		 System.out.println(personnesdb);
    		 request.setAttribute("personnes", personnesdb);
    		this.getServletContext().getRequestDispatcher("/WEB-INF/acceuil.jsp").forward(request, response);
    	}

    	/**
    	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    	 */
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		// TODO Auto-generated method stub
    		doGet(request, response);
    	}
       
    }

	
	
	
	
	
	
	
	

}
