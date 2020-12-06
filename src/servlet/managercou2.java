package servlet;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.alibaba.fastjson.JSONObject;
import dao.managercougetdata;
import javabean.stu_score;
public class managercou2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(" ’µΩ«Î«Û");  
		request.setCharacterEncoding("utf-8");
	      response.setCharacterEncoding("utf-8");
	      String nameString=request.getParameter("name");
	      managercougetdata mcougetdata=new managercougetdata();
	      ArrayList<stu_score> stu_scores=null;
	      try {
			stu_scores=mcougetdata.cougetstubyname(nameString);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	      String stuscoreString=JSONObject.toJSONString(stu_scores);
	      response.getWriter().write(stuscoreString);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
