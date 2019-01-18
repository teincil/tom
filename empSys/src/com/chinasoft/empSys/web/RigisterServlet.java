package com.chinasoft.empSys.web;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasoft.empSys.domain.Emp;
import com.chinasoft.empSys.service.IRigisterService;
import com.chinasoft.empSys.service.impl.RigisterService;

@WebServlet("/RigisterServlet")
public class RigisterServlet extends HttpServlet {
       
    public RigisterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 ServletContext context = request.getServletContext();
		  String encoding = context.getInitParameter("encoding");
			request.setCharacterEncoding(encoding);
			response.setContentType("text/html;charset="+encoding);
			
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
			IRigisterService rigister=new RigisterService();
			
			int i=rigister.insertEmp(name,password,gender,age,hiredate,salary,phone,email);
			if(i == 0) {
				request.setAttribute("rigister_msg", "账号已存在,请重新登陆");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}else {
				request.setAttribute("rigister_msg", "注册成功");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
