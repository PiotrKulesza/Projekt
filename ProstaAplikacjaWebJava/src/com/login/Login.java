package com.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.walidacja.Waliduj;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Waliduj wal = new Waliduj();
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass"); 
		
		if(wal.Waliduje(uname, pass)) {
			
			HttpSession session = request.getSession();
			session.setAttribute("username",uname);
			response.sendRedirect("index2.jsp");
		}else {
			response.sendRedirect("index.jsp");
		}
		
	}


}
