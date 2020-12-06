package studentservlet;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.stumodifymessage;
import javabean.student;
public class studentmodifymessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          request.setCharacterEncoding("utf-8");
          response.setCharacterEncoding("utf-8");
          String nameString=request.getParameter("name");
          String sexString=request.getParameter("sex");
          String ageString=request.getParameter("age");
          String passwordString=request.getParameter("password");
          int age=Integer.valueOf(ageString);
          student exiStudent=(student) request.getSession().getAttribute("existstu");
          stumodifymessage stumodifymessage=new stumodifymessage();
          int num=0;
          try {
			num=stumodifymessage.modify(exiStudent.getSid(), age, nameString, sexString, passwordString);
		} catch (SQLException e) {
			e.printStackTrace();
		}
        if (num>0) {
			response.getWriter().write("修改成功！");
			exiStudent.setSage(age);
			exiStudent.setSname(nameString);
			exiStudent.setSpassword(passwordString);
			exiStudent.setSsex(sexString);
		}
          else {
        	  response.getWriter().write("修改失败！");
		}   
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
