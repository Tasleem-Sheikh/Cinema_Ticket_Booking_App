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

import com.C_H_B_A.Service.Connection_DB;
import com.C_H_B_A.Service.Display_Bookings;
import com.C_H_B_A.Service.Update_ticket;

/**
 * Servlet implementation class Update_Controller
 */
@WebServlet("/update")
public class Update_Servelet
extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update_Servelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String movie = request.getParameter("movie");
		String language = request.getParameter("language");
		String seat_row = request.getParameter("seat_row");
		String seat_number = request.getParameter("seat_number");
		String u_email = request.getParameter("u_email");
		
		
		request.setAttribute("u_email", u_email);
		request.setAttribute("seat_number", seat_number);
		request.setAttribute("seat_number", seat_number);
		request.setAttribute("seat_row", seat_row);
		request.setAttribute("language", language);
		request.setAttribute("movie", movie);
		request.setAttribute("email", email);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/update_ticket.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String movie = request.getParameter("movie");
		String language = request.getParameter("language");
		String seat_row = request.getParameter("seat_row");
		String seat_number = request.getParameter("seat_number");
		String u_email = request.getParameter("u_email");
		
		
		Connection_DB connection = new Connection_DB();
		
		Connection con = connection.DBConnection();
		
		Update_ticket ut= new Update_ticket();
		ut.updateTicket(email,movie,language,seat_row,seat_number,u_email,con);
		
		request.setAttribute("update_msg","UPDATE COMPLETED");
		 Display_Bookings db= new Display_Bookings();
		 ResultSet rs = db.getAllBookings(con);
		
		request.setAttribute("results",rs);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/all_bookings.jsp");
		rd.forward(request, response);
	}

}
