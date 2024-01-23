package com.C_H_B_A.Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.C_H_B_A.Service.CancelBooking;
import com.C_H_B_A.Service.Connection_DB;
import com.C_H_B_A.Service.Display_Bookings;

/**
 * Servlet implementation class Delete_Servelet
 */
@WebServlet("/delete")
public class Cancel_Servelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Cancel_Servelet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String email = request.getParameter("email");
		Connection_DB db = new Connection_DB();

		Connection con = db.DBConnection();

		CancelBooking dr = new CancelBooking();
		dr.cancelBooking(con,email);
		
		request.setAttribute("cancelled", "YOUR BOOKING HAS BEEN CANCELEED");
		
		Display_Bookings DB= new Display_Bookings();
		ResultSet rs = DB.getAllBookings(con);
		
		request.setAttribute("results", rs);
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/all_bookings.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
