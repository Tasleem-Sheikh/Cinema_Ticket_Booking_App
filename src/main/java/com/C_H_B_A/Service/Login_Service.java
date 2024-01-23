package com.C_H_B_A.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Login_Service {
	Statement stmnt;

	public boolean verifylogin(String email, String password, Connection con) {
		try {
			stmnt = con.createStatement();

			ResultSet rs = stmnt.executeQuery(
					"select * from login_details where Email='" + email + "' and Password='" + password + "'");
			return rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;

	}

}
