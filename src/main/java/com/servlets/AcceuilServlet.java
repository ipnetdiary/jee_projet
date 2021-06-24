package com.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.ChambreDaoImpl;
import com.dao.DaoConfig;
import com.javabeins.Chambre;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AcceuilServlet
 */
@WebServlet("/AcceuilServlet")
public class AcceuilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     ChambreDaoImpl chambres;
    /**
     * Default constructor. 
     */
    public AcceuilServlet() {
        // TODO Auto-generated constructor stub
    	super();
    }
    
    public void init() throws ServletException {
        try {
        	
			DaoConfig daoConfig = DaoConfig.getInstance();
			
			chambres = daoConfig.getChambreDao();
			// DaoFactory daoFactory = DaoFactory.getInstance();
		      //  this.utilisateurDao = daoFactory.getUtilisateurDao();
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
		 List <Chambre> chanbre = new ArrayList<Chambre>();
		  chanbre = chambres.lister();
		System.out.println(chanbre);
	    request.setAttribute("chambres", chanbre);
			//this.getServletContext().getRequestDispatcher("/WEB-INF/").forward(request, response);
		RequestDispatcher dispatcher = request.getRequestDispatcher("");
		dispatcher.forward(request, response);
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		   doGet(request, response);
		
	    }
	
	}


