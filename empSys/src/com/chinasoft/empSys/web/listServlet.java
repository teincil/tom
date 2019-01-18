package com.chinasoft.empSys.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasoft.empSys.domain.Emp;
import com.chinasoft.empSys.service.IListService;
import com.chinasoft.empSys.service.impl.Listservice;

/**
 * 控制员工列表的servlet
 */
@WebServlet("/listServlet")
public class listServlet extends HttpServlet {
       
    public listServlet() {
    	
    	
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 ServletContext context = request.getServletContext();
		  String encoding = context.getInitParameter("encoding");
			request.setCharacterEncoding(encoding);
			response.setContentType("text/html;charset="+encoding);
			IListService list=new Listservice();
			List<Emp> Emps = list.findAllEmp();
			//把员工信息发到请求域，并发到JSP
			request.setAttribute("emp", Emps);
			request.getRequestDispatcher("/EmpList.jsp").forward(request, response);
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
