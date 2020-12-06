package servlet;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.managercouaddstu;
public class managercouadd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	         request.setCharacterEncoding("utf-8");
	         response.setCharacterEncoding("utf-8");
	         String cidString=request.getParameter("courseid");
	         String sidString=request.getParameter("studentid");
	         int cid=Integer.valueOf(cidString);
	         int sid=Integer.valueOf(sidString);
	         managercouaddstu mcas=new managercouaddstu();
	         int num=0;
	         try {
				num=mcas.addstu(sid, cid);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	         if(num>0)
	         {
	        	 response.getWriter().write("添加成功！");
	         }
	         else {
				response.getWriter().write("添加失败！");
			}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
