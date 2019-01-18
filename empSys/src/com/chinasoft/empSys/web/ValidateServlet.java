package com.chinasoft.empSys.web;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ValidateServlet")
public class ValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ValidateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = request.getServletContext();
		  String encoding = context.getInitParameter("encoding");
			request.setCharacterEncoding(encoding);
			response.setContentType("text/html;charset="+encoding);
			String str = "abcdefghijkmnpqrstuvwxyABCDEFGHJKLMNPQRSTUVWXY23456789";
			StringBuffer sb=new StringBuffer();
			for(int i=0;i<4;i++) {
				sb.append(str.charAt(getNum(str.length())));
			}
			//第三部  添加到session中
			HttpSession session = request.getSession();
			session.setAttribute("Validate_in_session", sb);
			// 第四步: 在内存中创建图片对象
			int width = 80;
			int height = 60;
			int imgType = BufferedImage.TYPE_INT_RGB;
			BufferedImage img = new BufferedImage(width, height, imgType);
			// 第五步: 在图片中获取到"画笔"对象
			Graphics g = img.getGraphics();

			g.setFont(new Font("楷体", Font.BOLD, 24));

			for (int i = 0; i < 5; i++) {
				g.setColor(new Color(getNum(256), getNum(256), getNum(256)));
				g.drawLine(getNum(10), getNum(40) + 10, getNum(70), getNum(40) + 10);
			}

			g.drawString(sb.toString(), 20, 20);
        response.setContentType("image/jpeg");
        response.setDateHeader("expries", -1);
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
//写给浏览器
		ImageIO.write(img, "jpg", response.getOutputStream());
		

			
	}
	private int getNum(int num) {
		Random random=new Random();
	return 	random.nextInt(num);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
