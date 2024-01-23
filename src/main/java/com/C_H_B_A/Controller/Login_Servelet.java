package com.C_H_B_A.Controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.C_H_B_A.Service.Login_Service;
import com.C_H_B_A.Service.Connection_DB;

/**
 * Servlet implementation class Login_Servelet
 */
@WebServlet("/login")
public class Login_Servelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login_Servelet() {
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
	String email = request.getParameter("email");
	String password = request.getParameter("password");
	Connection_DB db= new Connection_DB();
	Connection con = db.DBConnection();
	
	Login_Service login = new Login_Service();
	boolean verifylogin = login.verifylogin(email, password, con);
	
	if(verifylogin==true) {
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/Booking.jsp");
		rd.forward(request, response);
	}else {
		request.setAttribute("error_msg", "Invalid Email/Password");
		
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}
	

	
	}

}
