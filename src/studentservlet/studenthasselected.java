package studentservlet;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.alibaba.fastjson.JSONObject;
import dao.stugetmyscore;
import javabean.coursescore;
import javabean.student;
public class studenthasselected extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		student existstudent = (student) request.getSession().getAttribute("existstu");
        stugetmyscore stugetmyscore=new stugetmyscore();
        ArrayList<coursescore> coursescores=null;
        try {
			coursescores=stugetmyscore.getCoursescore(existstudent.getSid());
		} catch (SQLException e) {
			e.printStackTrace();
		}
        String coursescoreString=JSONObject.toJSONString(coursescores);
        response.getWriter().write(coursescoreString);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
