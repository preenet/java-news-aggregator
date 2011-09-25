import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public final class CJNALogFilter implements Filter {
	private FilterConfig filterConfigObj = null;

	public void init(FilterConfig filterConfigObj) {
		this.filterConfigObj = filterConfigObj;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		String remoteAddress = request.getRemoteAddr();
		String uri = ((HttpServletRequest) request).getRequestURI();
		String protocol = request.getProtocol();
		String userName ="";
		 if (request.getParameter("name") != null) {
			  userName = request.getParameter("name");
		 }

		chain.doFilter(request, response);
		filterConfigObj.getServletContext()
				.log("Logging Filter Servlet called");
		filterConfigObj.getServletContext().log("**************************");
		filterConfigObj.getServletContext().log(
				"User Logged ! " + userName  + " User IP: " + remoteAddress
						+ " Resource File: " + uri + " Protocol: " + protocol);
	}

}// end class CJNALofFilter