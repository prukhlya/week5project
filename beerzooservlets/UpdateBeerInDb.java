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
 * Servlet implementation class UpdateBeerInDb
 */
@WebServlet("/UpdateBeerInDb")
public class UpdateBeerInDb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBeerInDb() {
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
	
		Beer updateBeerInDb = new Beer();
		
		updateBeerInDb.setBeerID(Integer.parseInt(request.getParameter("beer_id")));
		updateBeerInDb.setName(request.getParameter("name"));
		updateBeerInDb.setCountryOfOrigin(request.getParameter("country_of_origin"));
		updateBeerInDb.setStyle(request.getParameter("style"));
		updateBeerInDb.setAbv(Double.parseDouble(request.getParameter("abv")));
		
		DAOBeer.updateToDatabase(updateBeerInDb);
		
		request.getRequestDispatcher("beerread.jsp").forward(request, response);
		
	} //dopost

}
