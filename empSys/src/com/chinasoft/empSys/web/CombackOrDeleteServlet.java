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
import com.chinasoft.empSys.service.IFindEmpByIdService;
import com.chinasoft.empSys.service.impl.FindEmpByIdService;
import com.chinasoft.empSys.service.impl.RigisterService;

/**
 * 恢复或者删除的Servlet
 */
@WebServlet("/CombackOrDeleteServlet")
public class CombackOrDeleteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = request.getServletContext();
		  String encoding = context.getInitParameter("encoding");
			request.setCharacterEncoding(encoding);
			response.setContentType("text/html;charset="+encoding);
			//从session中获得list集合
			
			 
			String cmd = request.getParameter("cmd");
			
			 if("comback".equals(cmd)) {
				 System.out.println("comback");
				 comback(request,response);
				 
			 }else if("delete".equals(cmd)) {
				 System.out.println("delete");
				 delete(request,response);
				 
			 }
	    
	}
	private void comback(HttpServletRequest request, HttpServletResponse response) {
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		System.out.println();
		 HttpSession session = request.getSession();
		 RigisterService rigisterService=new RigisterService();
		 
		
			
		Emp flag=null;	
		List<Emp> emps = (List<Emp>) session.getAttribute("emps");
		for (Emp emp : emps) {
			if(emp.getId() == id) {
				flag=emp;
				
				rigisterService.insertEmp(emp.getName(), emp.getPassword(), emp.getGender(),emp.getAge(), emp.getHiredate(), emp.getSalary(), emp.getPhone(), emp.getEmail());
				System.out.println("cao");
			}
		}
		emps.remove(flag);
		
		
		try {
			request.getRequestDispatcher("/Comback.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		 HttpSession session = request.getSession();
		List<Emp> list = (List<Emp>) session.getAttribute("emps");
		if(list == null) {
			request.getRequestDispatcher("/Comback.jsp").forward(request, response);
			return ;
		}
		for (Emp emp : list) {
			if(emp.getId() == id) {
				list.remove(emp);
			}
		}
		session.setAttribute("emps",list);
		
			request.getRequestDispatcher("/Comback.jsp").forward(request, response);
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
