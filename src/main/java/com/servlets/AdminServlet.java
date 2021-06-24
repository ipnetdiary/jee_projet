package com.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.AdminsDaoImpl;
import com.dao.ChambreDaoImpl;
import com.dao.DaoConfig;
import com.javabeins.Admin;
import com.javabeins.Chambre;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminsDaoImpl Admins;
	ChambreDaoImpl chambres;

    /**
     * Default constructor. 
     */
    public AdminServlet() {
        // TODO Auto-generated constructor stub
    	super();
    }

    public void init() throws ServletException {
        try {
        	
			DaoConfig daoConfig = DaoConfig.getInstance();
			
			Admins = daoConfig.getAdminsDao(); 
			chambres = daoConfig.getChambreDao();
			
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
			
			case "/insertadmin":
				AjouterAdmin(request, response);
				break;
				
			case "/updateadmin":
				updateAdmin(request, response);
				break;
			case "/deleteadmin":
				deleteAdmin(request, response);
				break;
				
			case "/insertch":
				AjouterChambre(request, response);
				break;
				
			case "/updatch":
				updateChamnre(request, response);
				break;
			case "/deletch":
				deleteChambre(request, response);
				break;
			default:
				listAdmin(request, response);
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
	
	private void listAdmin(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		 List <Admin> admin = new ArrayList<Admin>();
		 admin = Admins.lister();
		System.out.println(admin);
	    request.setAttribute("Admins", admin);
			//this.getServletContext().getRequestDispatcher("/WEB-INF/").forward(request, response);
		RequestDispatcher dispatcher = request.getRequestDispatcher("");
		dispatcher.forward(request, response);
	}
	
	private void AjouterAdmin(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Admin admin = new Admin(username, password);
		Admins.ajouter(admin);
		response.sendRedirect("list");
	}
	
	private void updateAdmin(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Admin admin = new Admin(id,username, password);

		Admins.modifier(admin,id);
		response.sendRedirect("list");
	}
	private void deleteAdmin(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Admins.supprimer(id);
		response.sendRedirect("list");

	}
	private void AjouterChambre(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int nbr_lit = Integer.parseInt(request.getParameter("nbr_lit"));
		int etage = Integer.parseInt(request.getParameter("etage"));
		int n_chambre = Integer.parseInt(request.getParameter("n_chambre"));
		String game = request.getParameter("game");
		String telephone = request.getParameter("telephone");
		int is_free = Integer.parseInt(request.getParameter("is_free"));
		int prix = Integer.parseInt(request.getParameter("prix"));
		Chambre chambre = new Chambre(nbr_lit, etage, n_chambre,game,telephone,is_free,prix);
		chambres.ajouter(chambre);
		response.sendRedirect("list");
	}
	
	private void updateChamnre(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		int nbr_lit = Integer.parseInt(request.getParameter("nbr_lit"));
		int etage = Integer.parseInt(request.getParameter("etage"));
		int n_chambre = Integer.parseInt(request.getParameter("n_chambre"));
		String game = request.getParameter("game");
		String telephone = request.getParameter("telephone");
		int is_free = Integer.parseInt(request.getParameter("is_free"));
		int prix = Integer.parseInt(request.getParameter("prix"));
		Chambre chambre = new Chambre(id,nbr_lit, etage, n_chambre,game,telephone,is_free,prix);

		chambres.modifier(chambre,id);
		response.sendRedirect("list");
	}
	private void deleteChambre(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		chambres.supprimer(id);
		response.sendRedirect("list");

	}
}
