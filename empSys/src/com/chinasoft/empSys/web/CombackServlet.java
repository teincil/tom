package com.chinasoft.empSys.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chinasoft.empSys.domain.Emp;

/**
 * 
 */
@WebServlet("/CombackServlet")
public class CombackServlet extends HttpServlet {
 
	
	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = request.getServletContext();
		  String encoding = context.getInitParameter("encoding");
			request.setCharacterEncoding(encoding);
			response.setContentType("text/html;charset="+encoding);
			
			
			//从session中获得list集合
		 HttpSession session = request.getSession();
		 
		 List<Emp> emps = (List<Emp>) session.getAttribute("emps");
		
		 request.setAttribute("emps", emps);
		 request.getRequestDispatcher("/Comback.jsp").forward(request, response);
		 
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
