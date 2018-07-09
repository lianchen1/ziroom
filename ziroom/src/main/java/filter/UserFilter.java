package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.PortableInterceptor.SUCCESSFUL;

public class UserFilter implements Filter{

	public void init(FilterConfig filterConfig) throws ServletException {
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		String url = request.getRequestURI();
		if(url.indexOf("ziruyu")>0) {
			Object obj = request.getSession().getAttribute("user");
			HttpSession session = (HttpSession) obj;
			if(session != null) {
				arg2.doFilter(request, response);
			}else {
				request.getRequestDispatcher("login.html").forward(request, response);
			}
		}else {
			arg2.doFilter(request, response);
		}
	}

	public void destroy() {
	}
	
}
