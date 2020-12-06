package studentservlet;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.studeletecou;
import javabean.student;
public class studentdeletemycou extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     request.setCharacterEncoding("utf-8");
	     response.setCharacterEncoding("utf-8");
	     String cidString=request.getParameter("cid");
	     int cid=Integer.valueOf(cidString);
	     student exiStudent=(student) request.getSession().getAttribute("existstu");
	     studeletecou studeletecou=new studeletecou();
	     int num=0;
	     try {
			num= studeletecou.deletecou(cid, exiStudent.getSid());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	     if(num>0)
	     {
	    	 response.getWriter().write("É¾³ý³É¹¦£¡");
	     }
	     else {
			response.getWriter().write("É¾³ýÊ§°Ü£¡");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
