package com.C_H_B_A.Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.C_H_B_A.Service.Booking_Service;
import com.C_H_B_A.Service.Connection_DB;

/**
 * Servlet implementation class Booking_Servelet
 */
@WebServlet("/book")
public class Booking_Servelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Booking_Servelet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/Booking.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String Name = request.getParameter("name");
		String Email = request.getParameter("email");
		String phone = request.getParameter("contact");
		String Movie = request.getParameter("movie");
		String Language = request.getParameter("language");
		String Row = request.getParameter("seat_row");
		String number = request.getParameter("seat_number");

		Pattern p = Pattern.compile("[6-9][0-9]{9}");
		Matcher matcher = p.matcher(phone);
		Pattern compile = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9_.]*@[0-9a-zA-Z]+([.][a-zA-Z]+)+");
		Matcher emailmatcher = compile.matcher(Email);

		if ((emailmatcher.find() && emailmatcher.group().equals(Email)) && matcher.find()
				&& matcher.group().equals(phone)) {
			Connection_DB Connection = new Connection_DB();
			Connection con = Connection.DBConnection();

			Booking_Service book = new Booking_Service();

			boolean status = book.checkForAlreadyBooked(Row, number, con);

			if (status == true) {
				request.setAttribute("already_booked", " Sorry....The seat has been alraedy booked.....");
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/Booking.jsp");
				rd.forward(request, response);
			} else {

				book.Booking(Name, Email, phone, Movie, Language, Row, number, con);

				request.setAttribute("booked", "Your Booking Has Been Successfull");

				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/Booking.jsp");
				rd.forward(request, response);
			}

		} else {

			request.setAttribute("Invalid_Email", "Provide Valid Phone Number and Email Format");
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/Booking.jsp");
			rd.forward(request, response);
		}

	}

}
