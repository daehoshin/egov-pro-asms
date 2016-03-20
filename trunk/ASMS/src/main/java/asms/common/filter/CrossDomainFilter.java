package asms.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * @PackageName asms.common.filter
 * @FileName CrossDomainFilter.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 3. 20.
 */
public class CrossDomainFilter implements Filter {

	private final Logger logger = Logger.getLogger(getClass());
	
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse servletResponse,
			FilterChain chain) throws IOException, ServletException {
		
		if (!(request instanceof HttpServletRequest)) {
			throw new ServletException("This filter can "
					+ " only process HttpServletRequest requests");
		}
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "origin, x-requested-with, content-type, accept");
		response.setHeader("X-UA-Compatible", "IE=edge");
		
		chain.doFilter(request, response);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}
	
}
