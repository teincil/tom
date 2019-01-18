package com.chinasoft.empSys.web;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import com.chinasoft.empSys.service.IUpdateService;
import com.chinasoft.empSys.service.impl.UpdateService;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
       
    public UpdateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 ServletContext context = request.getServletContext();
		  String encoding = context.getInitParameter("encoding");
			request.setCharacterEncoding(encoding);
			response.setContentType("text/html;charset="+encoding);
			String sid = request.getParameter("id");
			System.out.println("获取到的id"+sid);
			int id = Integer.parseInt(sid);
			
			
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String gender = request.getParameter("gender");
			String sage = request.getParameter("age");
			System.out.println();
			int age = Integer.parseInt(sage);
			String shiredate = request.getParameter("hiredate");
			Date hiredate = Date.valueOf(shiredate);
			String ssalary = request.getParameter("salary");
			Double salary = Double.valueOf(ssalary);
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
	       IUpdateService updateService=new UpdateService();
	       updateService.UpdateEmp(id,name,password,gender,age,hiredate,salary,phone,email);
	       response.sendRedirect("/empSys/listServlet");
	       
	       
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
