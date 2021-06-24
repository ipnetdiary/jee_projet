package com.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.dao.DaoConfig;
import com.dao.ReservationsDaoImpl;
import com.javabeins.Reservation;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReservationServlet
 */
@WebServlet("/ReservationServlet")
public class ReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ReservationsDaoImpl RSV;

    /**
     * Default constructor. 
     */
    public ReservationServlet() {
        // TODO Auto-generated constructor stub
    	super();
    }
    
    public void init() throws ServletException {
        try {
        	
			DaoConfig daoConfig = DaoConfig.getInstance();
			
			RSV = daoConfig.getReservationsDao(); 
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
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getServletPath();

		try {
			switch (action) {
			
			case "/insert":
				AjouterRSV(request, response);
				break;
				
			case "/update":
				updateRSV(request, response);
				break;
			case "/delete":
				deleteRSV(request, response);
				break;
				
			default:
				listRSV(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
	private void listRSV(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		 List <Reservation> reservation = new ArrayList<Reservation>();
		 reservation = RSV.lister();
		System.out.println(reservation);
	    request.setAttribute("RSV", reservation);
			//this.getServletContext().getRequestDispatcher("/WEB-INF/").forward(request, response);
		RequestDispatcher dispatcher = request.getRequestDispatcher("");
		dispatcher.forward(request, response);
	}
	
	private void AjouterRSV(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id_client = Integer.parseInt(request.getParameter("id_client"));
		int id_chambre = Integer.parseInt(request.getParameter("id_chambre"));
		String date_arriver = request.getParameter("date_arriver");
		String date_depart = request.getParameter("date_depart");
		String mode_payement = request.getParameter("mode_payement");
		int durre = Integer.parseInt(request.getParameter("durre"));
		Reservation reservation = new Reservation(id_client,id_chambre,date_arriver, date_depart, mode_payement,durre);
		RSV.ajouter(reservation);
		response.sendRedirect("list");
	}
	
	private void updateRSV(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		int id_client = Integer.parseInt(request.getParameter("id_client"));
		int id_chambre = Integer.parseInt(request.getParameter("id_chambre"));
		String date_arriver = request.getParameter("date_arriver");
		String date_depart = request.getParameter("date_depart");
		String mode_payement = request.getParameter("mode_payement");
		int durre = Integer.parseInt(request.getParameter("durre"));
		Reservation reservation = new Reservation(id_client,id_chambre,date_arriver, date_depart, mode_payement,durre);
		RSV.modifier(reservation,id);
		response.sendRedirect("list");
	}
	private void deleteRSV(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		RSV.supprimer(id);
		response.sendRedirect("list");

	}
}
