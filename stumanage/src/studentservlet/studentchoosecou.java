package studentservlet;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.stuchoosecou;
import javabean.student;
public class studentchoosecou extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        request.setCharacterEncoding("utf-8");
	        response.setCharacterEncoding("utf-8");
	        String cidString=request.getParameter("cid");
	        int cid=Integer.valueOf(cidString);
	        student exiStudent=(student) request.getSession().getAttribute("existstu");
	        stuchoosecou stuchoosecou=new stuchoosecou();
	        String msg=null;
	        try {
				msg=stuchoosecou.choosesou(exiStudent.getSid(), cid);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	        response.getWriter().write(msg);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
