package com.pracownik;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class Pracownik {
	//Zmienne dla SQL
		private String url="jdbc:mysql://db:3306/uczelnia?useTimezone=true&serverTimezone=UTC";
		private String username="root";
		private String password="121212";
		private int reply;
		private FTPClient ftp = new FTPClient();
		private String destination = "192.168.0.12";
		private String login = "FTP-USER";
		private String passwordFTP = "121212";
		
		
		public ResultSet danePracownika(String id) {
			System.getProperty("file.encoding","ISO-8859-2"); 
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection(url,username,password);
					PreparedStatement st=con.prepareStatement("SELECT imie,nazwisko FROM pracownik "
							+ "WHERE id_pracownika=? ");
							
					
					
					st.setString(1,id);
					ResultSet rs = st.executeQuery();
					return rs;
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				return null;
			}
		public ResultSet przedmiotyPrac(String id) {
			System.getProperty("file.encoding","ISO-8859-2"); 
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,username,password);
				PreparedStatement st=con.prepareStatement("SELECT kierunek.nazwa,przedmiot.nazwa,laborki.grupa,laborki.rocznik "
						+ "FROM kierunek,laborki,przedmiot "
						+ "WHERE kierunek.id_kierunku=laborki.id_kierunku "
						+ "AND przedmiot.id_pracownika=? "
						+ "AND laborki.id_pracownika=przedmiot.id_pracownika");
				st.setString(1,id);
				ResultSet rs = st.executeQuery();
				return rs;
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		public ResultSet uczniowiePrac(String id,String dane) {
			System.getProperty("file.encoding","ISO-8859-2"); 
			String[] splitedArray = null;
			splitedArray = dane.split("/");
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,username,password);
				PreparedStatement st=con.prepareStatement("SELECT student.imie,student.nazwisko,student.id_studenta,student.nr_indeksu "
						+ "FROM sprawozdania,kierunek,student,przedmiot,przedmioty_uczniow,laborki "
						+ "WHERE kierunek.id_kierunku=student.id_kierunku "
						+ "AND student.id_studenta=przedmioty_uczniow.id_studenta "
						+ "AND przedmioty_uczniow.id_przedmiotu=przedmiot.id_przedmiotu "
						+ "AND przedmiot.id_pracownika=? "
						+ "AND przedmiot.nazwa=? "
						+ "AND kierunek.nazwa=? "
						+ "AND student.rocznik=? "
						+ "AND student.grupa=? "
						+ "AND sprawozdania.id_laborek=laborki.id "
						+ "AND laborki.id_pracownika=przedmiot.id_pracownika "
						+ "AND sprawozdania.id_studenta=student.id_studenta;");
				st.setString(1,id);
				st.setString(2,splitedArray[1]);
				st.setString(3,splitedArray[0]);
				st.setString(4,splitedArray[3]);
				st.setString(5,splitedArray[2]);
				ResultSet rs = st.executeQuery();
				return rs;
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		public ResultSet sprPrac(String id,String dane) {
			System.getProperty("file.encoding","ISO-8859-2"); 
			String[] splitedArray = null;
			splitedArray = dane.split("/");
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,username,password);
				PreparedStatement st=con.prepareStatement("SELECT laborki.adres_lab_1,spr1.stan,spr1.adres,spr1.komentarz,spr1.ocena  "
						+ "FROM spr1,laborki,student,przedmiot,sprawozdania WHERE przedmiot.nazwa=? AND  student.id_studenta=? AND laborki.grupa=student.grupa "
						+ "AND laborki.id_przedmiotu=przedmiot.id_przedmiotu AND sprawozdania.spr_1_id=spr1.id AND "
						+ "laborki.id=sprawozdania.id_laborek AND student.id_studenta=sprawozdania.id_studenta UNION  SELECT laborki.adres_lab_2,spr2.stan,spr2.adres,spr2.komentarz,"
						+ "spr2.ocena  FROM spr2,laborki,student,przedmiot,sprawozdania WHERE przedmiot.nazwa=? AND  student.id_studenta=? "
						+ "AND laborki.grupa=student.grupa AND laborki.id_przedmiotu=przedmiot.id_przedmiotu AND sprawozdania.spr_2_id=spr2.id "
						+ "AND laborki.id=sprawozdania.id_laborek AND student.id_studenta=sprawozdania.id_studenta UNION  SELECT laborki.adres_lab_3,spr3.stan,spr3.adres,spr3.komentarz,"
						+ "spr3.ocena  FROM spr3,laborki,student,przedmiot,sprawozdania WHERE przedmiot.nazwa=? AND  student.id_studenta=? AND "
						+ "laborki.grupa=student.grupa AND laborki.id_przedmiotu=przedmiot.id_przedmiotu AND sprawozdania.spr_3_id=spr3.id "
						+ "AND laborki.id=sprawozdania.id_laborek AND student.id_studenta=sprawozdania.id_studenta UNION  SELECT laborki.adres_lab_4,spr4.stan,spr4.adres,spr4.komentarz,"
						+ "spr4.ocena  FROM spr4,laborki,student,przedmiot,sprawozdania WHERE przedmiot.nazwa=? AND  student.id_studenta=? AND "
						+ "laborki.grupa=student.grupa AND laborki.id_przedmiotu=przedmiot.id_przedmiotu AND sprawozdania.spr_4_id=spr4.id "
						+ "AND laborki.id=sprawozdania.id_laborek AND student.id_studenta=sprawozdania.id_studenta UNION  SELECT laborki.adres_lab_5,spr5.stan,spr5.adres,spr5.komentarz,"
						+ "spr5.ocena  FROM spr5,laborki,student,przedmiot,sprawozdania WHERE przedmiot.nazwa=? AND  student.id_studenta=? AND "
						+ "laborki.grupa=student.grupa AND laborki.id_przedmiotu=przedmiot.id_przedmiotu AND sprawozdania.spr_5_id=spr5.id "
						+ "AND laborki.id=sprawozdania.id_laborek AND student.id_studenta=sprawozdania.id_studenta UNION  SELECT laborki.adres_lab_6,spr6.stan,spr6.adres,spr6.komentarz,"
						+ "spr6.ocena  FROM spr6,laborki,student,przedmiot,sprawozdania WHERE przedmiot.nazwa=? AND  student.id_studenta=? AND "
						+ "laborki.grupa=student.grupa AND laborki.id_przedmiotu=przedmiot.id_przedmiotu AND sprawozdania.spr_6_id=spr6.id "
						+ "AND laborki.id=sprawozdania.id_laborek AND student.id_studenta=sprawozdania.id_studenta UNION  SELECT laborki.adres_lab_7,spr7.stan,spr7.adres,spr7.komentarz,"
						+ "spr7.ocena  FROM spr7,laborki,student,przedmiot,sprawozdania WHERE przedmiot.nazwa=? AND  student.id_studenta=? AND "
						+ "laborki.grupa=student.grupa AND laborki.id_przedmiotu=przedmiot.id_przedmiotu AND sprawozdania.spr_7_id=spr7.id "
						+ "AND laborki.id=sprawozdania.id_laborek AND student.id_studenta=sprawozdania.id_studenta UNION  SELECT laborki.adres_lab_8,spr8.stan,spr8.adres,spr8.komentarz,"
						+ "spr8.ocena  FROM spr8,laborki,student,przedmiot,sprawozdania WHERE przedmiot.nazwa=? AND  student.id_studenta=? AND "
						+ "laborki.grupa=student.grupa AND laborki.id_przedmiotu=przedmiot.id_przedmiotu AND sprawozdania.spr_8_id=spr8.id "
						+ "AND laborki.id=sprawozdania.id_laborek AND student.id_studenta=sprawozdania.id_studenta UNION  SELECT laborki.adres_lab_9,spr9.stan,spr9.adres,spr9.komentarz,"
						+ "spr9.ocena  FROM spr9,laborki,student,przedmiot,sprawozdania WHERE przedmiot.nazwa=? AND  student.id_studenta=? AND "
						+ "laborki.grupa=student.grupa AND laborki.id_przedmiotu=przedmiot.id_przedmiotu AND sprawozdania.spr_9_id=spr9.id "
						+ "AND laborki.id=sprawozdania.id_laborek AND student.id_studenta=sprawozdania.id_studenta UNION  SELECT laborki.adres_lab_10,spr10.stan,spr10.adres,spr10.komentarz,"
						+ "spr10.ocena  FROM spr10,laborki,student,przedmiot,sprawozdania WHERE przedmiot.nazwa=? AND  student.id_studenta=? AND "
						+ "laborki.grupa=student.grupa AND laborki.id_przedmiotu=przedmiot.id_przedmiotu AND sprawozdania.spr_10_id=spr10.id "
						+ "AND laborki.id=sprawozdania.id_laborek AND student.id_studenta=sprawozdania.id_studenta UNION  SELECT laborki.adres_lab_11,spr11.stan,spr11.adres,spr11.komentarz,"
						+ "spr11.ocena  FROM spr11,laborki,student,przedmiot,sprawozdania WHERE przedmiot.nazwa=? AND student.id_studenta=? AND "
						+ "laborki.grupa=student.grupa AND laborki.id_przedmiotu=przedmiot.id_przedmiotu AND sprawozdania.spr_11_id=spr11.id "
						+ "AND laborki.id=sprawozdania.id_laborek AND student.id_studenta=sprawozdania.id_studenta UNION  SELECT laborki.adres_lab_12,spr12.stan,spr12.adres,spr12.komentarz,"
						+ "spr12.ocena  FROM spr12,laborki,student,przedmiot,sprawozdania WHERE przedmiot.nazwa=? AND  student.id_studenta=? AND "
						+ "laborki.grupa=student.grupa AND laborki.id_przedmiotu=przedmiot.id_przedmiotu AND sprawozdania.spr_12_id=spr12.id "
						+ "AND laborki.id=sprawozdania.id_laborek AND student.id_studenta=sprawozdania.id_studenta UNION  SELECT laborki.adres_lab_13,spr13.stan,spr13.adres,spr13.komentarz,"
						+ "spr13.ocena  FROM spr13,laborki,student,przedmiot,sprawozdania WHERE przedmiot.nazwa=? AND  student.id_studenta=? AND "
						+ "laborki.grupa=student.grupa AND laborki.id_przedmiotu=przedmiot.id_przedmiotu AND sprawozdania.spr_13_id=spr13.id "
						+ "AND laborki.id=sprawozdania.id_laborek AND student.id_studenta=sprawozdania.id_studenta UNION  SELECT laborki.adres_lab_14,spr14.stan,spr14.adres,spr14.komentarz,"
						+ "spr14.ocena  FROM spr14,laborki,student,przedmiot,sprawozdania WHERE przedmiot.nazwa=? AND student.id_studenta=? AND "
						+ "laborki.grupa=student.grupa AND laborki.id_przedmiotu=przedmiot.id_przedmiotu AND sprawozdania.spr_14_id=spr14.id "
						+ "AND laborki.id=sprawozdania.id_laborek AND student.id_studenta=sprawozdania.id_studenta UNION  SELECT laborki.adres_lab_15,spr15.stan,spr15.adres,spr15.komentarz,"
						+ "spr15.ocena  FROM spr15,laborki,student,przedmiot,sprawozdania WHERE przedmiot.nazwa=? AND  student.id_studenta=? AND "
						+ "laborki.grupa=student.grupa AND laborki.id_przedmiotu=przedmiot.id_przedmiotu AND sprawozdania.spr_15_id=spr15.id "
						+ "AND laborki.id=sprawozdania.id_laborek");
				st.setString(1,splitedArray[1]);
				st.setString(2,id);
				st.setString(3,splitedArray[1]);
				st.setString(4,id);
				st.setString(5,splitedArray[1]);
				st.setString(6,id);
				st.setString(7,splitedArray[1]);
				st.setString(8,id);
				st.setString(9,splitedArray[1]);
				st.setString(10,id);
				st.setString(11,splitedArray[1]);
				st.setString(12,id);
				st.setString(13,splitedArray[1]);
				st.setString(14,id);
				st.setString(15,splitedArray[1]);
				st.setString(16,id);
				st.setString(17,splitedArray[1]);
				st.setString(18,id);
				st.setString(19,splitedArray[1]);
				st.setString(20,id);
				st.setString(21,splitedArray[1]);
				st.setString(22,id);
				st.setString(23,splitedArray[1]);
				st.setString(24,id);
				st.setString(25,splitedArray[1]);
				st.setString(26,id);
				st.setString(27,splitedArray[1]);
				st.setString(28,id);
				st.setString(29,splitedArray[1]);
				st.setString(30,id);
				ResultSet rs = st.executeQuery();
				return rs;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		public void zapKom(String id, String nrlab, String komentarz, String dane) {
			System.getProperty("file.encoding","ISO-8859-2"); 
			String[] splitedArray = null;
			splitedArray = dane.split("/");
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,username,password);
				String instrukcja="UPDATE sprawozdania,student,spr"+nrlab+",przedmiot,laborki "
						+ "SET spr"+nrlab+".komentarz=? "
						+ "WHERE student.id_studenta=? "
						+ "AND student.id_studenta=sprawozdania.id_studenta "
						+ "AND sprawozdania.spr_"+nrlab+"_id=spr"+nrlab+".id "
						+ "AND laborki.id=sprawozdania.id_laborek "
						+ "AND laborki.id_przedmiotu=przedmiot.id_przedmiotu "
						+ "AND przedmiot.nazwa=?";
				PreparedStatement st=con.prepareStatement(instrukcja);
				st.setString(1,komentarz);
				st.setString(2,id);
				st.setString(3,splitedArray[1]);
				st.executeUpdate();
				st.close();
				
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void zapOcene(String id, String nrlab, String ocena, String dane) {
			System.getProperty("file.encoding","ISO-8859-2"); 
			String[] splitedArray = null;
			splitedArray = dane.split("/");
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,username,password);
				String instrukcja="UPDATE sprawozdania,student,spr"+nrlab+",przedmiot,laborki "
						+ "SET spr"+nrlab+".ocena=? "
						+ "WHERE student.id_studenta=? "
						+ "AND student.id_studenta=sprawozdania.id_studenta "
						+ "AND sprawozdania.spr_"+nrlab+"_id=spr"+nrlab+".id "
						+ "AND laborki.id=sprawozdania.id_laborek "
						+ "AND laborki.id_przedmiotu=przedmiot.id_przedmiotu "
						+ "AND przedmiot.nazwa=?";
				PreparedStatement st=con.prepareStatement(instrukcja);
				st.setString(1,ocena);
				st.setString(2,id);
				st.setString(3,splitedArray[1]);
				st.executeUpdate();
				st.close();
				
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void zapStan(String id, String nrlab,String stan, String dane) {
			System.getProperty("file.encoding","ISO-8859-2"); 
			String[] splitedArray = null;
			splitedArray = dane.split("/");
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,username,password);
				String instrukcja="UPDATE sprawozdania,student,spr"+nrlab+",przedmiot,laborki "
						+ "SET spr"+nrlab+".stan=? "
						+ "WHERE student.id_studenta=? "
						+ "AND student.id_studenta=sprawozdania.id_studenta "
						+ "AND sprawozdania.spr_"+nrlab+"_id=spr"+nrlab+".id "
						+ "AND laborki.id=sprawozdania.id_laborek "
						+ "AND laborki.id_przedmiotu=przedmiot.id_przedmiotu "
						+ "AND przedmiot.nazwa=?";
				PreparedStatement st=con.prepareStatement(instrukcja);
				st.setString(1,stan);
				st.setString(2,id);
				st.setString(3,splitedArray[1]);
				st.executeUpdate();
				st.close();
				
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public ResultSet labPrac(String id,String dane) {
			System.getProperty("file.encoding","ISO-8859-2"); 
			String[] splitedArray = null;
			splitedArray = dane.split("/");
			
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,username,password);
				PreparedStatement st=con.prepareStatement("SELECT laborki.adres_lab_1,laborki.adres_lab_2,laborki.adres_lab_3,laborki.adres_lab_4,"
						+ "laborki.adres_lab_5,laborki.adres_lab_6,laborki.adres_lab_7,laborki.adres_lab_8,laborki.adres_lab_9,"
						+ "laborki.adres_lab_10,laborki.adres_lab_11,laborki.adres_lab_12,laborki.adres_lab_13,laborki.adres_lab_14,"
						+ "laborki.adres_lab_15 FROM laborki,przedmiot,kierunek "
						+ "WHERE laborki.id_pracownika=? "
						+ "AND laborki.grupa=? "
						+ "AND przedmiot.nazwa=?  "
						+ "AND kierunek.nazwa=? "
						+ "AND laborki.rocznik=? "
						+ "AND kierunek.id_kierunku=laborki.id_kierunku "
						+ "AND przedmiot.id_przedmiotu=laborki.id_przedmiotu "
						+ "AND laborki.adres_lab_1 IS NULL OR laborki.adres_lab_1 IS NOT NULL");
				
				st.setString(1,id);
				st.setString(2,splitedArray [2]);
				st.setString(3,splitedArray [1]);
				st.setString(4,splitedArray [0]);
				st.setString(5,splitedArray [3]);
				
				ResultSet rs = st.executeQuery();
				return rs;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		public String drogaSprPrac(String id,String dane) {
			System.getProperty("file.encoding","ISO-8859-2"); 
			String[] splitedArray = null;
			splitedArray = dane.split("/");
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,username,password);
				PreparedStatement st=con.prepareStatement("SELECT student.rocznik,student.grupa,student.nr_indeksu,przedmiot.nazwa,kierunek.nazwa "
						+ "FROM student,kierunek WHERE student.id_kierunku=kierunek.id_kierunku "
						+ "AND student.id_studenta=?;");
				st.setString(1,id);
				ResultSet rs = st.executeQuery();
				String path="";
				while(rs.next()) {
					path=rs.getString("kierunek.nazwa")+"\\"+rs.getString("student.rocznik")+"\\"+splitedArray[1]+"\\"
						+rs.getString("student.grupa")+"\\"+rs.getString("student.nr_indeksu")+"\\";
				}
				st.close();
				return path;
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			return null;
		}
		
		public ResultSet nazwaSprPrac(String nrlab,String id,String dane) {
			System.getProperty("file.encoding","ISO-8859-2"); 
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,username,password);
				String spr="spr"+nrlab+".adres";
				PreparedStatement st=con.prepareStatement("SELECT "+spr+" FROM przedmiot,sprawozdania, laborki,spr"+nrlab
						+ " WHERE laborki.id_pracownika=? "
						+ "AND laborki.id=sprawozdania.id_laborek "
						+ "AND przedmiot.id_przedmiotu=laborki.id_przedmiotu "
						+ "AND przedmiot.nazwa=? "
						+ "AND sprawozdania.spr_"+nrlab+"_id=spr"+nrlab+".id;");
				
				
				st.setString(1,id);
				ResultSet rs = st.executeQuery();
				return rs;
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			return null;
		}
		
		public void zapiszLabPrac(String id,String filename,String nrlab,String kierunek,String przedmiot,String grupa,String rocznik) {
			System.getProperty("file.encoding","ISO-8859-2"); 
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,username,password);
				String instrukcja="UPDATE laborki, kierunek,przedmiot SET laborki.adres_lab_"+nrlab+" =? "
						+ "WHERE laborki.id_pracownika=? "
						+ "AND laborki.id_przedmiotu=przedmiot.id_przedmiotu "
						+ "AND przedmiot.nazwa=? "
						+ "AND laborki.id_kierunku=kierunek.id_kierunku "
						+ "AND kierunek.nazwa=? "
						+ "AND laborki.rocznik=? "
						+ "AND laborki.grupa=?";
				PreparedStatement st=con.prepareStatement(instrukcja);
				st.setString(1,filename);
				st.setString(2,id);
				st.setString(3,przedmiot);
				st.setString(4,kierunek);
				st.setString(5,rocznik);
				st.setString(6,grupa);
				st.executeUpdate();
				st.close();
				
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		public ResultSet adresLabPrac(String nrlab,String przedmiot,String grupa,String kierunek,String rocznik ,String id) {
			System.getProperty("file.encoding","ISO-8859-2"); 
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,username,password);
				String laborka="adres_lab_"+nrlab;
				PreparedStatement st=con.prepareStatement("SELECT "+laborka+" FROM laborki,przedmiot,kierunek "
						+ "WHERE laborki.id_pracownika=? "
						+ "AND laborki.grupa=? "
						+ "AND przedmiot.nazwa=?  "
						+ "AND kierunek.nazwa=? "
						+ "AND laborki.rocznik=? "
						+ "AND kierunek.id_kierunku=laborki.id_kierunku "
						+ "AND przedmiot.id_przedmiotu=laborki.id_przedmiotu "
						+ "AND laborki.adres_lab_1 IS NULL OR laborki.adres_lab_1 IS NOT NULL");			
					
				st.setString(1,id);
				st.setString(2,grupa);
				st.setString(3,przedmiot);
				st.setString(4,kierunek);
				st.setString(5,rocznik);
				ResultSet rs = st.executeQuery();
				return rs;
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			return null;
		}
		
		public ResultSet daneDoLabPrac(String id) {
			System.getProperty("file.encoding","ISO-8859-2"); 
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,username,password);
				PreparedStatement st=con.prepareStatement("SELECT kierunek.id_kierunku,przedmiot.id_przedmiotu,student.rocznik ,student.grupa,kierunek.nazwa,przedmiot.nazwa "
						+ "FROM student,przedmiot,przedmioty_uczniow,kierunek "
						+ "WHERE przedmiot.id_przedmiotu=przedmioty_uczniow.id_przedmiotu "
						+ "AND student.id_studenta=przedmioty_uczniow.id_studenta "
						+ "AND student.id_kierunku=kierunek.id_kierunku "
						+ "AND student.id_studenta!= ALL(SELECT student.id_studenta "
						+ "FROM student , laborki ,przedmioty_uczniow,pracownik "
						+ "WHERE przedmioty_uczniow.id_studenta=student.id_studenta "
						+ "AND laborki.rocznik=student.rocznik AND pracownik.id_pracownika=laborki.id_pracownika "
						+ "AND laborki.grupa=student.grupa AND student.id_kierunku=laborki.id_kierunku "
						+ "AND pracownik.id_pracownika=?)GROUP BY kierunek.id_kierunku,przedmiot.id_przedmiotu,student.rocznik,student.grupa,student.id_kierunku,przedmiot.nazwa");			
					
				st.setString(1,id);
				ResultSet rs = st.executeQuery();
				return rs;
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			return null;
		}
		
		public void dodajLab(String id, String dane) {
			System.getProperty("file.encoding","ISO-8859-2"); 
			String[] splitedArray = null;
			splitedArray = dane.split("/");
			
			Pracownik prac = new Pracownik();
			prac.stworzFolderyDlaLab(splitedArray[0],splitedArray[1],splitedArray[2],splitedArray[3]);
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,username,password);
				String instrukcja="INSERT INTO laborki ( id_przedmiotu, id_pracownika,grupa,id_kierunku,rocznik,"
						+ "adres_lab_1,adres_lab_2,adres_lab_3,adres_lab_4,adres_lab_5,"
						+ "adres_lab_6,adres_lab_7,adres_lab_8,adres_lab_9,adres_lab_10,"
						+ "adres_lab_11,adres_lab_12,adres_lab_13,adres_lab_14,adres_lab_15) "
						+ "VALUES(?,?,?,?,?,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null);";
				PreparedStatement st=con.prepareStatement(instrukcja);
				st.setString(1,splitedArray[1]);
				st.setString(2,id);
				st.setString(3,splitedArray[2]);
				st.setString(4,splitedArray[0]);
				st.setString(5,splitedArray[3]);
				st.executeUpdate();
				
				st.close();
				
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public void stworzFolderyDlaLab( String id_kierunku,String id_przedmiotu,String grupa,String rocznik) {
			System.getProperty("file.encoding","ISO-8859-2"); 
			try {
				Pracownik prac = new Pracownik();
				ResultSet names = prac.nazwaPrzedmiotuKierunku(id_kierunku,id_przedmiotu);
				String kierunek=null;
				String przedmiot=null;
				while(names.next()) {
				kierunek= names.getString("kierunek.nazwa");
				przedmiot= names.getString("przedmiot.nazwa");
				}
				ftp.connect(destination);
					ftp.login(login, passwordFTP);
					ftp.enterLocalPassiveMode();
					ftp.setFileType(FTP.BINARY_FILE_TYPE);
					reply = ftp.getReplyCode();
					if(FTPReply.isPositiveCompletion(reply)){
						ftp.makeDirectory("\\INSTRUKCJE");
						ftp.makeDirectory("\\INSTRUKCJE\\"+rocznik);
						ftp.makeDirectory("\\INSTRUKCJE\\"+rocznik+"\\"+kierunek);
						ftp.makeDirectory("\\INSTRUKCJE\\"+rocznik+"\\"+kierunek+"\\"+przedmiot);
						ftp.makeDirectory("\\INSTRUKCJE\\"+rocznik+"\\"+kierunek+"\\"+przedmiot+"\\"+grupa);
						ftp.disconnect();
					}else {
						System.out.println("Connection Failed");
						ftp.disconnect();
					}

			} catch (IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public ResultSet nazwaPrzedmiotuKierunku(String id_kierunku,String id_przedmiotu) {
			System.getProperty("file.encoding","ISO-8859-2"); 
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,username,password);
				PreparedStatement st=con.prepareStatement("SELECT kierunek.nazwa,przedmiot.nazwa "
						+ "FROM przedmiot,kierunek "
						+ "WHERE przedmiot.id_przedmiotu=? "
						+ "AND kierunek.id_kierunku=?");			
					
				st.setString(1,id_przedmiotu);
				st.setString(2,id_kierunku);
				ResultSet rs = st.executeQuery();
				return rs;
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			return null;
		}
}
