package com.C_H_B_A.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Update_ticket {
	
	Statement stmnt;

	public void updateTicket(String email, String movie, String language, String seat_row, String seat_number,
			String u_email,Connection con) {
 try {
	stmnt = con.createStatement();
	stmnt.executeUpdate("update booking_details set Movie='"+movie+"',Lang='"+language+"',Seat_Row='"+seat_row+"',Seat_Number='"+seat_number+"',Email='"+u_email+"' where Email='"+email+"'");
	
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}

}
