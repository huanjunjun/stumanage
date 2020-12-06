package studentservlet;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.alibaba.fastjson.JSONObject;
import dao.stumycourse;
import javabean.course;
import javabean.student;
public class studentmycourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          request.setCharacterEncoding("utf-8");
          response.setCharacterEncoding("utf-8");
          student exiStudent=(student) request.getSession().getAttribute("existstu");
          stumycourse stumycourse=new stumycourse();
          ArrayList<course> courses=null;
          try {
			courses=stumycourse.getmyCourses(exiStudent.getSid());
		} catch (SQLException e) {
			e.printStackTrace();
		} 
          String coursesString=JSONObject.toJSONString(courses);
          response.getWriter().write(coursesString);
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
