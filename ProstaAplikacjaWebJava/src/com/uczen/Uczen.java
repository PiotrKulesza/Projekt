package com.uczen;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class Uczen {
	//Zmienne dla SQL
	private String url="jdbc:mysql://db:3306/uczelnia?useTimezone=true&serverTimezone=UTC";
	private String username="root";
	private String password="121212";
	private int reply;
	private FTPClient ftp = new FTPClient();
	private String destination = "192.168.0.12";
	private String login = "FTP-USER";
	private String passwordFTP = "121212";
	
	public ResultSet daneUcznia(String id) {
		System.getProperty("file.encoding","ISO-8859-2"); 
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,username,password);
				PreparedStatement st=con.prepareStatement("SELECT imie,nazwisko FROM student "
						+ "WHERE id_studenta=? ");
						
				
				
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
	
	public ResultSet przedmiotyUcznia(String id) {
		System.getProperty("file.encoding","ISO-8859-2"); 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st=con.prepareStatement("SELECT przedmiot.nazwa FROM przedmioty_uczniow,przedmiot,laborki,sprawozdania WHERE przedmioty_uczniow.id_studenta=? "
					+ "AND przedmiot.id_przedmiotu=przedmioty_uczniow.id_przedmiotu "
					+ "AND przedmiot.id_przedmiotu=laborki.id_przedmiotu "
					+ "AND laborki.id=sprawozdania.id_laborek "
					+ "AND sprawozdania.id_studenta=przedmioty_uczniow.id_studenta");
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
	
	
	public ResultSet laborkiUcznia(String id,String przedmiot) {
		System.getProperty("file.encoding","ISO-8859-2"); 
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
			st.setString(1,przedmiot);
			st.setString(2,id);
			st.setString(3,przedmiot);
			st.setString(4,id);
			st.setString(5,przedmiot);
			st.setString(6,id);
			st.setString(7,przedmiot);
			st.setString(8,id);
			st.setString(9,przedmiot);
			st.setString(10,id);
			st.setString(11,przedmiot);
			st.setString(12,id);
			st.setString(13,przedmiot);
			st.setString(14,id);
			st.setString(15,przedmiot);
			st.setString(16,id);
			st.setString(17,przedmiot);
			st.setString(18,id);
			st.setString(19,przedmiot);
			st.setString(20,id);
			st.setString(21,przedmiot);
			st.setString(22,id);
			st.setString(23,przedmiot);
			st.setString(24,id);
			st.setString(25,przedmiot);
			st.setString(26,id);
			st.setString(27,przedmiot);
			st.setString(28,id);
			st.setString(29,przedmiot);
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
	
		public ResultSet instrukcjaUcz(String nrlab,String przedmiot,String id) {
			System.getProperty("file.encoding","ISO-8859-2"); 
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,username,password);
				String laborka="adres_lab_"+nrlab;
				PreparedStatement st=con.prepareStatement("SELECT "+laborka+" FROM laborki,student,przedmiot,sprawozdania "
						+ "WHERE przedmiot.nazwa=? "
						+ "AND  student.id_studenta=? "
						+ "AND student.id_studenta=sprawozdania.id_studenta "
						+ "AND laborki.grupa=student.grupa "
						+ "AND laborki.id_przedmiotu=przedmiot.id_przedmiotu "
						+ "AND laborki.id=sprawozdania.id_laborek");
				
				
				st.setString(1,przedmiot);
				st.setString(2,id);
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
		
		public String drogaLabUcz(String id,String przedmiot) {
			System.getProperty("file.encoding","ISO-8859-2"); 
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,username,password);
				PreparedStatement st=con.prepareStatement("SELECT student.grupa,student.rocznik,przedmiot.nazwa,kierunek.nazwa "
						+ "FROM kierunek,przedmiot,student,sprawozdania,laborki "
						+ "WHERE laborki.id_kierunku=kierunek.id_kierunku "
						+ "AND przedmiot.id_przedmiotu=laborki.id_przedmiotu "
						+ "AND przedmiot.nazwa=? "
						+ "AND student.id_studenta=sprawozdania.id_studenta "
						+ "AND sprawozdania.id_laborek=laborki.id "
						+ "AND student.id_studenta=?;");
				st.setString(1,przedmiot);
				st.setString(2,id);
				ResultSet rs = st.executeQuery();
				String path="";
				while(rs.next()) {
					path=rs.getString("student.rocznik")+"\\"+rs.getString("kierunek.nazwa")+"\\"+rs.getString("przedmiot.nazwa")+"\\"+rs.getString("student.grupa")+"\\";
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
		
		public String drogaSprUcz(String id,String przedmiot) {
			System.getProperty("file.encoding","ISO-8859-2"); 
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,username,password);
				PreparedStatement st=con.prepareStatement("SELECT student.rocznik,student.grupa,student.nr_indeksu,kierunek.nazwa "
						+ "FROM student,kierunek WHERE student.id_kierunku=kierunek.id_kierunku "
						+ "AND student.id_studenta=?;");
				st.setString(1,id);
				ResultSet rs = st.executeQuery();
				String path="";
				while(rs.next()) {
					path=rs.getString("kierunek.nazwa")+"\\"+rs.getString("student.rocznik")+"\\"+przedmiot+"\\"
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
		
		public ResultSet nazwaSprUcz(String nrlab,String id,String przedmiot) {
			System.getProperty("file.encoding","ISO-8859-2"); 
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,username,password);
				String spr="spr"+nrlab+".adres";
				PreparedStatement st=con.prepareStatement("SELECT "+spr+" FROM przedmiot,przedmioty_uczniow,sprawozdania, student,spr"+nrlab
						+ " WHERE student.id_studenta=? "
						+ "AND przedmioty_uczniow.id_studenta=student.id_studenta "
						+ "AND przedmioty_uczniow.id_przedmiotu=przedmiot.id_przedmiotu "
						+ "AND przedmiot.nazwa=? "
						+ "AND student.id_studenta=sprawozdania.id_studenta "
						+ "AND sprawozdania.spr_"+nrlab+"_id=spr"+nrlab+".id;");
				
				
				st.setString(1,id);
				st.setString(1,przedmiot);
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
		
		public void zapiszNazweSprUcz(String id,String filename,String nrlab,String przedmiot) {
			System.getProperty("file.encoding","ISO-8859-2"); 
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,username,password);
				String instrukcja="UPDATE sprawozdania,student,spr"+nrlab+",przedmiot,laborki SET spr"+nrlab+".adres=?,spr"+nrlab+".stan=? "
						+ "WHERE student.id_studenta=? "
						+ "AND student.id_studenta=sprawozdania.id_studenta "
						+ "AND sprawozdania.spr_"+nrlab+"_id=spr"+nrlab+".id "
						+ "AND laborki.id=sprawozdania.id_laborek "
						+ "AND laborki.id_przedmiotu=przedmiot.id_przedmiotu "
						+ "AND przedmiot.nazwa=?";
				PreparedStatement st=con.prepareStatement(instrukcja);
				st.setString(1,filename);
				st.setString(2, "Nie_sprawdzone");
				st.setString(3,id);
				st.setString(4,przedmiot);
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
		
		public ResultSet daneDoLabUcz(String id) {
			System.getProperty("file.encoding","ISO-8859-2"); 
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,username,password);
				PreparedStatement st=con.prepareStatement("SELECT laborki.id,przedmiot.nazwa,laborki.id_pracownika,laborki.id_przedmiotu FROM student,laborki,przedmiot "
						+ "WHERE student.id_studenta=? AND laborki.id_przedmiotu=przedmiot.id_przedmiotu "
						+ "AND student.rocznik=laborki.rocznik and student.grupa=laborki.grupa "
						+ "AND student.id_kierunku=laborki.id_kierunku AND "
						+ "NOT exists (SELECT sprawozdania.id_laborek FROM sprawozdania "
						+ "WHERE sprawozdania.id_studenta=student.id_studenta AND laborki.id=sprawozdania.id_laborek)");			
					
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
		
		
		public void menuSpr(String id, String dane) {
			Uczen un = new Uczen();
			un.rozpocznijSpr(id,dane);
			for(int i=1;i<=15;i++) {
				un.podSpr(i);
			}	
			un.polonczSpr(id,dane);
			un.stworzFolderyDlaSpr(id, dane);
			
		}
		
		
		public void podSpr(int i) {
			System.getProperty("file.encoding","ISO-8859-2"); 
			String nazwa = "spr"+i;
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,username,password);
				String instrukcja="INSERT INTO "+nazwa+" (  adres, stan,ocena,komentarz) VALUES(null,'Nie_dodane',null,null);";
				PreparedStatement st=con.prepareStatement(instrukcja);
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
		
		public void rozpocznijSpr(String id, String dane) {
			System.getProperty("file.encoding","ISO-8859-2"); 
			String[] splitedArray = null;
			splitedArray = dane.split("/");
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,username,password);
				String instrukcja="INSERT INTO sprawozdania ( id_przedmiotu, id_studenta,id_pracownika,id_laborek) "
						+ "VALUES(?,?,?,?);";
				PreparedStatement st=con.prepareStatement(instrukcja);
				st.setString(1,splitedArray[2]);
				st.setString(2,id);
				st.setString(3,splitedArray[1]);
				st.setString(4,splitedArray[0]);
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
		
		public void polonczSpr(String id, String dane) {
			System.getProperty("file.encoding","ISO-8859-2"); 
			try {
				Uczen un = new Uczen();
				String x =un.idSpr(id,dane);
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,username,password);
				String instrukcja="UPDATE sprawozdania SET sprawozdania.spr_1_id=?,sprawozdania.spr_2_id=?,sprawozdania.spr_3_id=?,"
						+ "sprawozdania.spr_4_id=?,sprawozdania.spr_5_id=?,sprawozdania.spr_6_id=?,sprawozdania.spr_7_id=?,"
						+ "sprawozdania.spr_8_id=?,sprawozdania.spr_9_id=?,sprawozdania.spr_10_id=?,sprawozdania.spr_11_id=?,"
						+ "sprawozdania.spr_12_id=?,sprawozdania.spr_13_id=?,sprawozdania.spr_14_id=?,sprawozdania.spr_15_id=? "
						+ "WHERE sprawozdania.id_sprawozdania=? "
						+ "AND sprawozdania.id_studenta=? ";
				PreparedStatement st=con.prepareStatement(instrukcja);
				st.setString(1,x);
				st.setString(2,x);
				st.setString(3,x);
				st.setString(4,x);
				st.setString(5,x);
				st.setString(6,x);
				st.setString(7,x);
				st.setString(8,x);
				st.setString(9,x);
				st.setString(10,x);
				st.setString(11,x);
				st.setString(12,x);
				st.setString(13,x);
				st.setString(14,x);
				st.setString(15,x);
				st.setString(16,x);
				st.setString(17,id);
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
		
		public String idSpr(String id,String dane) {
			System.getProperty("file.encoding","ISO-8859-2"); 
			String[] splitedArray = null;
			splitedArray = dane.split("/");
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,username,password);
				PreparedStatement st=con.prepareStatement("SELECT sprawozdania.id_sprawozdania FROM sprawozdania "
						+ "WHERE sprawozdania.id_studenta=? "
						+ "AND sprawozdania.id_laborek=?;");			
					
				st.setString(1,id);
				st.setString(2,splitedArray[0]);
				ResultSet rs = st.executeQuery();
				String x=null;
				while(rs.next()) {
					x=rs.getString("sprawozdania.id_sprawozdania");
				}
				return x;
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			return null;
		}
		
		public void stworzFolderyDlaSpr( String id,String dane) {
			System.getProperty("file.encoding","ISO-8859-2"); 
			try {
				Uczen un = new Uczen();
				String[] splitedArray = null;
				splitedArray = dane.split("/");
				ResultSet names = un.daneDoFolderow(id,splitedArray[2]);
				String kierunek=null;
				String przedmiot=null;
				String numer=null;
				String rocznik=null;
				String grupa=null;
				while(names.next()) {
				kierunek= names.getString("kierunek.nazwa");
				przedmiot= names.getString("przedmiot.nazwa");
				numer= names.getString("student.nr_indeksu");
				rocznik= names.getString("student.rocznik");
				grupa= names.getString("student.grupa");
				}
				ftp.connect(destination);
					ftp.login(login, passwordFTP);
					ftp.enterLocalPassiveMode();
					ftp.setFileType(FTP.BINARY_FILE_TYPE);
					reply = ftp.getReplyCode();
					if(FTPReply.isPositiveCompletion(reply)){
						ftp.makeDirectory("\\SPRAWOZDANIA");
						ftp.makeDirectory("\\SPRAWOZDANIA\\"+kierunek);
						ftp.makeDirectory("\\SPRAWOZDANIA\\"+kierunek+"\\"+rocznik);
						ftp.makeDirectory("\\SPRAWOZDANIA\\"+kierunek+"\\"+rocznik+"\\"+grupa);
						ftp.makeDirectory("\\SPRAWOZDANIA\\"+kierunek+"\\"+rocznik+"\\"+przedmiot+"\\"+grupa);
						ftp.makeDirectory("\\SPRAWOZDANIA\\"+kierunek+"\\"+rocznik+"\\"+przedmiot+"\\"+grupa+"\\"+numer);
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
		
		public ResultSet daneDoFolderow(String id,String id_przedmiotu) {
			System.getProperty("file.encoding","ISO-8859-2"); 
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,username,password);
				PreparedStatement st=con.prepareStatement("SELECT student.rocznik,student.grupa,student.nr_indeksu,przedmiot.nazwa,kierunek.nazwa "
						+ "FROM student,przedmioty_uczniow,przedmiot,kierunek WHERE student.id_studenta=przedmioty_uczniow.id_studenta "
						+ "AND przedmiot.id_przedmiotu=przedmioty_uczniow.id_przedmiotu "
						+ "AND student.id_kierunku=kierunek.id_kierunku "
						+ "AND student.id_studenta=? "
						+ "AND przedmiot.id_przedmiotu=? ");
				st.setString(1,id);
				st.setString(2,id_przedmiotu);
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
