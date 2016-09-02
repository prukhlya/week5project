package com.beerzooservlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beerzoo.Beer;
import com.beerzoo.DAOBeer;

/**
 * Servlet implementation class DeleteBeerFromDb
 */
@WebServlet("/DeleteBeerFromDb")
public class DeleteBeerFromDb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBeerFromDb() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Beer deleteBeerFromDb = new Beer();
		
		deleteBeerFromDb.setBeerID(Integer.parseInt(request.getParameter("beer_id")));
		
		DAOBeer.deleteFromDB(deleteBeerFromDb);
		
		request.getRequestDispatcher("beerread.jsp").forward(request, response);
	}

}
