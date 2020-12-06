package servlet;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.alibaba.fastjson.JSONObject;
import dao.manager_showallstu;
import javabean.student;
public class managerstu1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             manager_showallstu mshowall=new manager_showallstu();
             request.setCharacterEncoding("utf-8");
             response.setCharacterEncoding("utf-8");
             ArrayList<student> students=null;
             try {
				students=mshowall.showall();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
             String stusString=JSONObject.toJSONString(students);
             response.getWriter().write(stusString);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
