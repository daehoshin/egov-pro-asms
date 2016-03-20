package asms.common.filter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

/**
 * @PackageName asms.common.filter
 * @FileName AjaxAwareAuthenticationEntryPoint.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 3. 20.
 */
public class AjaxAwareAuthenticationEntryPoint extends LoginUrlAuthenticationEntryPoint {
	
	private final Logger logger = Logger.getLogger(getClass());

	public AjaxAwareAuthenticationEntryPoint(String loginFormUrl) {
		setLoginFormUrl(loginFormUrl);
	}

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
	
		// Ajax 통신인 경우, 권한이 없으면 바로 403 에러 발생
		if (request.getHeader("x-requested-with") != null) {
			String value = request.getHeader("x-requested-with");
			if ("XMLHttpRequest".equals(value)) {
				response.sendError(HttpServletResponse.SC_FORBIDDEN, "Access Denied");
				return;
			}
		}
		
		// 최상위(/) 페이지의 경우, 권한이 없으면 로그인 페이지로 이동
		if ("/".equals(request.getRequestURI())) {
			response.sendRedirect("/welcome.jsp");
			return;
		}
		
		super.commence(request, response, authException);
	}
}
