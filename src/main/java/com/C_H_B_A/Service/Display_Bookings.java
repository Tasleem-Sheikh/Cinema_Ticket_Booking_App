package com.C_H_B_A.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Display_Bookings {
	
	
	Statement stmnt;

	public ResultSet getAllBookings(Connection connection) {
	
		try {
			stmnt=connection.createStatement();
			 ResultSet rs = stmnt.executeQuery("select * from booking_details");
			 return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

}
