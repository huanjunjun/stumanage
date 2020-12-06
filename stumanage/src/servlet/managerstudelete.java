package servlet;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.manstudelete;
public class managerstudelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String id=request.getParameter("deletebyid");
	    int sid=Integer.valueOf(id);
	    manstudelete manstudelete=new manstudelete();
	    int num=0;
	    try {
			 num=manstudelete.delete(sid);
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
