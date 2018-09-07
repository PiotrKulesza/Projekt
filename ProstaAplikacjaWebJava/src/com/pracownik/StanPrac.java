package com.pracownik;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/StanPrac")
public class StanPrac extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("ISO-8859-2");
		String username=request.getParameter("username");
		String nrlab=request.getParameter("nrlab");
		String stan=request.getParameter("Stan");
		String dane=request.getParameter("dane");
		
		
		Pracownik prac = new Pracownik();
		prac.zapStan(username, nrlab, stan,dane);
		response.sendRedirect("sprawozdania_p.jsp");
	}

}
