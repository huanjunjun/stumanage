package servlet;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.tree.VariableHeightLayoutCache;
import javabean.managercoudeletestu;
public class managercoudelete1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String cidString = request.getParameter("couid");
		String sidString = request.getParameter("deletesid");
		int cid = Integer.valueOf(cidString);
		int sid = Integer.valueOf(sidString);
        System.out.println("1");
		managercoudeletestu mcds=new managercoudeletestu();
		System.out.println("2");
		int num = 0;
		try {
			num = mcds.deletebyid(cid, sid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (num > 0) {
			response.getWriter().write("É¾³ý³É¹¦£¡");
		} else { 
            response.getWriter().write("É¾³ýÊ§°Ü£¡");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
