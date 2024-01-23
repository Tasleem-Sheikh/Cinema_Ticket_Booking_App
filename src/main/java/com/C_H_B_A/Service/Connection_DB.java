package com.C_H_B_A.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection_DB {
	Connection con;
	public Connection DBConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Cinema_Hall_Booking_App","root","Z1xcvbnm@#");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return con;
		
	}
	

}
