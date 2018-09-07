package com.pracownik;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;


@MultipartConfig
@WebServlet("/PrzeslijLabPrac")
public class PrzeslijLabPrac extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	private int reply;
	
	private FTPClient ftp = new FTPClient();
	
	private String destination = "192.168.0.12";
	private String login = "FTP-USER";
	private String password = "121212";
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("ISO-8859-2");
	    Part filePart = request.getPart("file_name"); 
	    String username=request.getParameter("username");
	    String nrlab=request.getParameter("nrlab");
	    String dane=request.getParameter("dane");
	    String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
	    InputStream fileContent = filePart.getInputStream();
		String[] splitedArray = null;
		splitedArray = dane.split("/");
		
		try {
			Pracownik prac = new Pracownik();
			ftp.connect(destination);
				ftp.login(login, password);
				ftp.enterLocalPassiveMode();
				ftp.setFileType(FTP.BINARY_FILE_TYPE);
				reply = ftp.getReplyCode();
				if(FTPReply.isPositiveCompletion(reply)){
				String filepath="INSTRUKCJE\\"+splitedArray[3]+"\\" +splitedArray[0]+"\\" +splitedArray[1] +"\\"+splitedArray[2]+"\\" + fileName;
				ftp.storeFile(filepath, fileContent);
				prac.zapiszLabPrac(username, fileName,nrlab,splitedArray[0],splitedArray[1],splitedArray[2],splitedArray[3]);
					ftp.disconnect();
				}else {
					System.out.println("Connection Failed");
					ftp.disconnect();
				}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		response.sendRedirect("instrukcje_p.jsp");

	}

}
