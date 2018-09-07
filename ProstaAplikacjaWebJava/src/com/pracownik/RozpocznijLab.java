package com.pracownik;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RozpocznijLab")
public class RozpocznijLab extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String dane=request.getParameter("dane");
		Pracownik prac = new Pracownik();
		prac.dodajLab(username, dane);
		response.sendRedirect("nauczajlab_p.jsp");
		
	}

}
