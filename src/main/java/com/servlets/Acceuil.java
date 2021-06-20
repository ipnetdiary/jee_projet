package com.servlets;

import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;

import com.dao.DaoConfig;
import com.dao.PersonneDaoImpl;
import com.javabeins.Personne;


/**
 * Servlet implementation class Acceuil
 */
@WebServlet("/acceuil")
public class Acceuil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PersonneDaoImpl personnes;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Acceuil() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException {
        try {
        	
			DaoConfig daoConfig = DaoConfig.getInstance();
			
			personnes = daoConfig.getPersonnesDao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		 List<Personne> personnesdb = new ArrayList<Personne>();
		 
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
