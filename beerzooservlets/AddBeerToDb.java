package com.beerzooservlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beerzoo.DAOBeer;
import com.beerzoo.Beer;

/**
 * Servlet implementation class AddToDb
 */
@WebServlet("/AddBeerToDb")
public class AddBeerToDb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBeerToDb() {
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

		Beer addBeerToDb = new Beer();
		
		addBeerToDb.setName(request.getParameter("name"));
		addBeerToDb.setCountryOfOrigin(request.getParameter("country_of_origin"));
		addBeerToDb.setStyle(request.getParameter("style"));
		addBeerToDb.setAbv(Double.parseDouble(request.getParameter("abv")));
		
		DAOBeer.writeToDatabase(addBeerToDb);
		
		request.getRequestDispatcher("beerread.jsp").forward(request, response);
	} // do post

}
