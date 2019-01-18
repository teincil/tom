package com.chinasoft.empSys.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasoft.empSys.domain.Emp;
import com.chinasoft.empSys.service.IFindEmpByIdService;
import com.chinasoft.empSys.service.IListService;
import com.chinasoft.empSys.service.impl.FindEmpByIdService;
import com.chinasoft.empSys.service.impl.Listservice;

/**
 * empSys的Servlet
 */
@WebServlet("/empSysServlet")
public class empSysServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		if("add".equals(cmd)) {
			System.out.println("add");
			add(request,response);
		}else if("del".equals(cmd)) {
			del(request,response);
		}else if("list".equals(cmd)) {
			System.out.println("list");
			list(request,response);
		}else if("update".equals(cmd)) {
			update(request,response);
		}
	
	}
	/**
	 * 修改学生信息的Servlet
	 * @param request
	 * @param response
	 */
private void update(HttpServletRequest request, HttpServletResponse response) {
		
	}

/**
 * 控制员工信息显示的Servlet
 * @param request
 * @param response
 * @throws ServletException
 * @throws IOException
 */
	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IListService list=new Listservice();
		List<Emp> Emps = list.findAllEmp();
		//把员工信息发到请求域，并发到JSP
		request.setAttribute("emp", Emps);
		request.getRequestDispatcher("/EmpList.jsp").forward(request, response);
	}

/**
 * 删除员工信息的Servlet
 * @param request
 * @param response
 */
	private void del(HttpServletRequest request, HttpServletResponse response) {
		
	}

/**
 * 员工注册的Servlet
 * @param request
 * @param response
 */
	private void add(HttpServletRequest request, HttpServletResponse response) {
		
	}
	/**
	 * 根据员工id查找员工并显示在注册页面
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
private void findEmpById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
