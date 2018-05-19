package com.login.walidacja;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Sesja {
	private String url="jdbc:mysql://localhost:3306/uczelnia?useTimezone=true&serverTimezone=UTC";
	private String username="root";
	private String password="121212";
	private String pracownik=null;
	private String student=null;
	
	public String Pracownik(String uname,String pass) {
			
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,username,password);
				PreparedStatement st=con.prepareStatement("SELECT id_pracownika FROM logowanie WHERE email=? AND haslo=?");
				st.setString(1,uname);
				st.setString(2,pass);
				ResultSet rs = st.executeQuery();
				if(rs.next()){
				pracownik = rs.getString("id_pracownika");
				}
				if(pracownik==null) {
					return null;
				}
				else return pracownik;
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException se) {
				// TODO Auto-generated catch block
				se.printStackTrace();
			}
			
			return null;
		}
	
		public String Student(String uname,String pass) {
			
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,username,password);
				PreparedStatement st2=con.prepareStatement("SELECT id_studenta FROM logowanie WHERE email=? AND haslo=?");
				st2.setString(1,uname);
				st2.setString(2,pass);
				ResultSet rs2 = st2.executeQuery();
				if(rs2.next()){
				student = rs2.getString("id_studenta");
				}
				if(student==null) {
					return null;
				}
				else return student;
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException se) {
				// TODO Auto-generated catch block
				se.printStackTrace();
			}
			
			return null;
		}
	
	}
	

	
		
	
