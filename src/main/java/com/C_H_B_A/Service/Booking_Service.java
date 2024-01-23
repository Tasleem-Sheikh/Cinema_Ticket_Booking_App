package com.C_H_B_A.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Booking_Service {
	PreparedStatement ps;
	Pattern p;
	Statement stmnt;

	public void Booking(String name, String email, String phone, String movie, String lang, String srow, String snum,
			Connection con) {
		String q = "insert into Booking_details values(?,?,?,?,?,?,?)";
//		System.out.println(phone);
		Pattern p = Pattern.compile("[6-9][0-9]{9}");
		Matcher matcher = p.matcher(phone);
		if (matcher.find() && matcher.group().equals(phone)) {
			try {
				ps = con.prepareStatement(q);
				ps.setString(1, name);
				ps.setString(2, email);
				ps.setString(3, phone);
				ps.setString(4, movie);
				ps.setString(5, lang);
				ps.setString(6, srow);
				ps.setString(7, snum);

				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {

		}
	}

	public boolean checkForAlreadyBooked(String row, String number, Connection con) {

		try {
			stmnt = con.createStatement();
			ResultSet rs = stmnt.executeQuery(
					"select * from booking_details where Seat_Row='" + row + "' AND Seat_Number='" + number + "'");

			return rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

}
