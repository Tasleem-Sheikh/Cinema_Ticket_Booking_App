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

/**
 * Servlet implementation class All_Bookings
 */
@WebServlet("/all_bookings")
public class All_Bookings extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public All_Bookings() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Connection_DB con= new Connection_DB();
		Connection connection = con.DBConnection();
		
		Display_Bookings db= new Display_Bookings();
		ResultSet rs=db.getAllBookings(connection);
		
		request.setAttribute("results", rs);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/all_bookings.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
