package com.C_H_B_A.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CancelBooking {
	Statement stmnt;

	public void cancelBooking(Connection con,String email) {
		 try {
			stmnt = con.createStatement();
			
			stmnt.executeUpdate("delete from booking_details where Email='"+email+"'");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
