package studentservlet;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.mansignin;
import dao.studentsignin;
import javabean.manager;
import javabean.student;
public class stusignin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String stuid = request.getParameter("sid");
		String stupassword = request.getParameter("password");
		int studentid=Integer.valueOf(stuid);
		student student1=new student();
		student1.setSid(studentid);
		student1.setSpassword(stupassword);
		student existstu=null;
		studentsignin studentsignin=new studentsignin();
		try {
			existstu = studentsignin.studentsignin(student1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (existstu == null) {
			response.getWriter().write("1");
			System.out.println("µÇÂ½Ê§°Ü");
		} else {
		    request.getSession().setAttribute("existstu", existstu);
		    response.getWriter().write("2");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
