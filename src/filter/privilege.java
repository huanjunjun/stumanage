package filter;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javabean.student;
public class privilege implements Filter {
    public privilege() {    }
	public void destroy() {	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request1= (HttpServletRequest) request;
		student exiStudent=(student) request1.getSession().getAttribute("existstu");
		if( exiStudent==null )
		{
	    	request1.getRequestDispatcher("/signin_student.html").forward(request1, response );
		}
		else {
			chain.doFilter(request1, response);
		}
	}
	public void init(FilterConfig fConfig) throws ServletException {
	}
}
