package servlet;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.managercouscoremodify;
public class managercoumodify extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("接收到请求");
	    request.setCharacterEncoding("utf-8");
	    response.setCharacterEncoding("utf-8");
	    String sidString=request.getParameter("sid");
	    String cidString=request.getParameter("cid");
	    String scoreString=request.getParameter("score");
	    int sid=Integer.valueOf(sidString);
	    int cid=Integer.valueOf(cidString);
	    int score=Integer.valueOf(scoreString);
	    managercouscoremodify mcsm=new managercouscoremodify();
	    int num=0;
	    try {
			num=mcsm.modifyscorebyid(cid, sid, score);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    if(num>0)
	    {
	    	response.getWriter().write("修改成功！");
	    }
	    else {
			response.getWriter().write("修改失败！");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
