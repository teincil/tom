package com.chinasoft.empSys.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chinasoft.empSys.domain.Emp;
import com.chinasoft.empSys.service.ILoginService;
import com.chinasoft.empSys.service.impl.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  ServletContext context = request.getServletContext();
	  String encoding = context.getInitParameter("encoding");
		request.setCharacterEncoding(encoding);
		response.setContentType("text/html;charset="+encoding);
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		ILoginService loginService=new LoginService();
		Emp emp = loginService.findEmpByNameAndPassword(name, password);
		if(emp != null) {
			//用户登录信息存入session
			HttpSession session = request.getSession();
			session.setAttribute("emp", emp);
			SimpleDateFormat sdf=new SimpleDateFormat("HH-mm-ss");
			
			String lasttime = sdf.format(new Date());
			Cookie[] cookies = request.getCookies();
			if(cookies != null) {
				Cookie c=null;
				for (Cookie cookie : cookies) {
					if("lasttime".equals(cookie)) {
					    c=cookie;
					    break;
					}
				}
				if(c!= null) {
					String value = c.getValue();
					request.setAttribute("lasttime", value);
					c.setValue(lasttime);
					response.addCookie(c);
					request.getRequestDispatcher("/index.jsp").forward(request, response);
				}else {
					c=new Cookie("lasttime", lasttime);
					c.setPath("/");
					c.setMaxAge(60*60*24*365);
					request.setAttribute("lasttime", lasttime);
					response.addCookie(c);
					request.getRequestDispatcher("/index.jsp").forward(request, response);
				}
			}else {
				Cookie c=new Cookie("lasttime", lasttime);
				c.setPath("/");
				c.setMaxAge(60*60*24*365);
				request.setAttribute("lasttime", lasttime);
				response.addCookie(c);
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
			
			

			
			response.getWriter().write("登陆成功，3s后回到主页");
			response.setHeader("refresh", "3,url="+context.getContextPath()+"index.jsp");
			return ;
		}else {
			request.setAttribute("error_msg", "账号不存在,请重新登陆");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
