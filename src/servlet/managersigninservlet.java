package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.mansignin;
import javabean.manager;


public class managersigninservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String adminname=request.getParameter("username");
	        String adminpassword=request.getParameter("password");
	        manager manager1=new manager();
	        manager1.setMname(adminname);;
	        manager1.setMpassword(adminpassword);;
	        manager existmanager=null;
	        mansignin mansignin1=new mansignin();
	        try {
				existmanager=mansignin1.signin(manager1);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	        if(existmanager==null)
	        {
	        	request.setAttribute("msg", "用戶名或密碼錯誤");
	        	response.getWriter().write("1");
	        	System.out.println("登陆失败");
	        }
	        else {
	        	System.out.println("登陆成功");
                response.getWriter().write("2");
	        	request.getSession().setAttribute("existmanager", existmanager);
			}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
