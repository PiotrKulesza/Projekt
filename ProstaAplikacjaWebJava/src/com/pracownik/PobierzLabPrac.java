package com.pracownik;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;


@WebServlet("/PobierzLabPrac")
public class PobierzLabPrac extends HttpServlet {
       
    
	
	private int reply;
	private FTPClient ftp = new FTPClient();
	private String destination = "192.168.0.12";
	private String login = "FTP-USER";
	private String password = "121212";
	private String instrukcja;
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("ISO-8859-2");
		String dane=request.getParameter("dane");
		String username=request.getParameter("username");
		String nrlab=request.getParameter("nrlab");
		String[] splitedArray = null;
		splitedArray = dane.split("/");
		try {
			Pracownik prac = new Pracownik();
			ResultSet name = prac.adresLabPrac(nrlab, splitedArray[1],splitedArray[2],splitedArray[0],splitedArray[3], username);
			String x="adres_lab_"+nrlab;
			while(name.next()) {
			instrukcja= name.getString(x);
			}
			ftp.connect(destination);
				ftp.login(login, password);
				ftp.enterLocalPassiveMode();
				ftp.setFileType(FTP.BINARY_FILE_TYPE);
				reply = ftp.getReplyCode();
				if(FTPReply.isPositiveCompletion(reply)){
					
					
					String mimeType = "application/octet-stream";
					response.setContentType(mimeType);
					String headerKey = "Content-Disposition";
					String headerValue = String.format("attachment; filename=\"%s\"", instrukcja);
					response.setHeader(headerKey, headerValue);
					OutputStream outputStream1 = response.getOutputStream();
					
					String remoteFile1 = "\\INSTRUKCJE\\"+splitedArray[3]+"\\"+splitedArray[0]+"\\"+splitedArray[1]+"\\"+splitedArray[2]+"\\"+instrukcja;
					
					
		            ftp.retrieveFile(remoteFile1, outputStream1);
		            outputStream1.close();
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

}
