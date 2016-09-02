package com.beerzoo;

import java.sql.*;
import java.util.ArrayList;


public class DAOBeer {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/?user=rootautoReconnect=true&useSSL=false";
	static final String USER = "root";
	static final String PASSWORD = "sesame";
	
	static Connection CONN = null;
	static Statement STMT = null;
	static PreparedStatement PREP_STMT = null;
	static ResultSet RES_SET = null;
	
	public static ArrayList<Beer> ourBeer = new ArrayList<>();
	
	public static void connToDB() { // method connects to the database

		try {

			Class.forName(JDBC_DRIVER);
			System.out.println("Trying to connect to Beer Heaven...");
			CONN = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			System.out.println("Connected to the Database.");
		} catch (Exception e) {
			System.out.println("Failed to connect, you must be a Prohibitionist.");
			e.printStackTrace();
		}

	} // connToDB
	
	public static void readFromDB() {

		connToDB();

		try {

			STMT = CONN.createStatement();
			RES_SET = STMT.executeQuery("SELECT * FROM beer_schema.beer_zoo;");

			while (RES_SET.next()) {

				Beer beerInDB = new Beer();
				
				beerInDB.setBeerID(RES_SET.getInt("beer_id"));
				beerInDB.setName(RES_SET.getString("name"));
				beerInDB.setCountryOfOrigin(RES_SET.getString("country_of_origin"));
				beerInDB.setStyle(RES_SET.getString("style"));
				beerInDB.setAbv(RES_SET.getDouble("abv"));
				
				ourBeer.add(beerInDB);

			}

		for (Beer beer : ourBeer) {
			System.out.println(beer);
		}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}

	} //read
	
	public static void writeToDatabase(Beer beer) {

		connToDB();

		try {

			PREP_STMT = CONN.prepareStatement(insertToDB);

			PREP_STMT.setString(1, beer.getName());
			PREP_STMT.setString(2, beer.getCountryOfOrigin());
			PREP_STMT.setString(3, beer.getStyle());
			PREP_STMT.setDouble(4, beer.getAbv());

			PREP_STMT.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} //write

	public static void deleteFromDB(Beer beer) {

		connToDB();

		try {
			PREP_STMT = CONN.prepareStatement(deleteFromDB);
			PREP_STMT.setInt(1, beer.getBeerID());
			PREP_STMT.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}// deletefromDB
	
	public static void updateToDatabase(Beer beer) {

		connToDB();

		try {

			PREP_STMT = CONN.prepareStatement(updateToDB);

			PREP_STMT.setInt(1, beer.getBeerID());
			PREP_STMT.setString(2, beer.getName());
			PREP_STMT.setString(3, beer.getCountryOfOrigin());
			PREP_STMT.setString(4, beer.getStyle());
			PREP_STMT.setDouble(5, beer.getAbv()); 
			PREP_STMT.setInt(6, beer.getBeerID());

			PREP_STMT.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	} // updateToDatabase
	
	private static String insertToDB = "INSERT INTO `beer_schema`.`beer_zoo`"
			+ "(name, country_of_origin, style, abv)" + " VALUES " + "(?, ?, ?, ?)";
	
	public static String deleteFromDB = "DELETE FROM `beer_schema`.`beer_zoo`" + "WHERE beer_id= ?";
	
	private static String updateToDB = "UPDATE `beer_schema`.`beer_zoo`SET" + " beer_id = ?," + " name = ?,"
			+ " country_of_origin = ?," + " style = ?," + " abv = ?" + "WHERE beer_id = ?";

//	private static String updateToDB = "UPDATE `zoo`.`animals_in_zoo`SET" + " animal_id = ?," + " animal_species = ?,"
//			+ " animal_name = ?," + "animal_age = ?," + "animal_weight = ?" + "WHERE animal_id = ?";
//
//	public static String deleteFromDB = "DELETE FROM `zoo`.`animals_in_zoo`" + "WHERE animal_id= ?";
//	
} // class DAOBeer
