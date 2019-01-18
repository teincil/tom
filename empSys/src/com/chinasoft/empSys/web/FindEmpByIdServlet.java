package com.chinasoft.empSys.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasoft.empSys.domain.Emp;
import com.chinasoft.empSys.service.IFindEmpByIdService;
import com.chinasoft.empSys.service.impl.FindEmpByIdService;

/**
 * Servlet implementation class FindEmpByIdServlet
 */
@WebServlet("/FindEmpByIdServlet")
public class FindEmpByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public FindEmpByIdServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 ServletContext context = request.getServletContext();
		  String encoding = context.getInitParameter("encoding");
			request.setCharacterEncoding(encoding);
			response.setContentType("text/html;charset="+encoding);
			String sid = request.getParameter("id");
			int id = Integer.parseInt(sid);
			IFindEmpByIdService findEmp=new FindEmpByIdService();
			Emp emp=findEmp.findEmpById(id);
			request.setAttribute("emp", emp);
			request.getRequestDispatcher("/Update.jsp").forward(request, response);
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
