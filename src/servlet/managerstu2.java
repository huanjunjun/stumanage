package servlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.alibaba.fastjson.JSONObject;
import javabean.managerfindstu;
import javabean.student;
public class managerstu2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String stuid = request.getParameter("stuid");
		Integer studentid = Integer.valueOf(stuid);
		System.out.println(studentid.intValue());
		managerfindstu mfindstu = new managerfindstu();
		student theStudent = null;
		try {
			theStudent = mfindstu.findbyid(studentid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String stusString=JSONObject.toJSONString(theStudent);
		response.getWriter().write(stusString);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
