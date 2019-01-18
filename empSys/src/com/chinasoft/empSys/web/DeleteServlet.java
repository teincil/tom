package com.chinasoft.empSys.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chinasoft.empSys.domain.Emp;
import com.chinasoft.empSys.service.IDeleteService;
import com.chinasoft.empSys.service.IFindEmpByIdService;
import com.chinasoft.empSys.service.impl.DeleteService;
import com.chinasoft.empSys.service.impl.FindEmpByIdService;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	List<Emp> list = new ArrayList<Emp>();
    public DeleteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 ServletContext context = request.getServletContext();
		  String encoding = context.getInitParameter("encoding");
			request.setCharacterEncoding(encoding);
			response.setContentType("text/html;charset="+encoding);
			//将信息存入session中
		HttpSession session = request.getSession();	
		//从前台获取要删除的ID
			String sid = request.getParameter("id");
			int id = Integer.parseInt(sid);
			IFindEmpByIdService find=new FindEmpByIdService();
			Emp emp = find.findEmpById(id);
			
			list.add(emp);
			System.out.println(list);
			session.setAttribute("emps", list);
			IDeleteService delete=new DeleteService();
			delete.DeleteEmpById(id);
			request.getRequestDispatcher("/listServlet").forward(request, response);
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
