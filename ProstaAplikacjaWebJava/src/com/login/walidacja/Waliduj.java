package com.login.walidacja;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Waliduj {
	
	String url="jdbc:mysql://db:3306/uczelnia?useTimezone=true&serverTimezone=UTC";
	String username="root";
	String password="121212";
	
	public boolean Waliduje(String uname,String pass) {
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st=con.prepareStatement("SELECT email,haslo FROM logowanie WHERE email=? AND haslo=?");
			st.setString(1,uname);
			st.setString(2,pass);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		}
		
		return false;
	}

}
