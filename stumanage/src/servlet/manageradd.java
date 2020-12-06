package servlet;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.manageraddstu;
public class manageradd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           request.setCharacterEncoding("utf-8");
           response.setCharacterEncoding("utf-8");
           String idString=request.getParameter("id");
           String nameString=request.getParameter("name");
           String sexString=request.getParameter("sex");
           String ageString=request.getParameter("age");
           String majorString=request.getParameter("major");
           String passwordString=request.getParameter("password");
           int id=Integer.valueOf(idString);
           int age=Integer.valueOf(ageString);
           manageraddstu mas=new manageraddstu();
           int num=0;
           try {
			num=mas.insert(id, nameString, sexString, age, majorString, passwordString);
		} catch (SQLException e) {
			e.printStackTrace();
		}
           System.out.println("1");
           System.out.println(num);
           if (num==1) {
			response.getWriter().write("添加成功！");
		}else {
			response.getWriter().write("添加失败！");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
