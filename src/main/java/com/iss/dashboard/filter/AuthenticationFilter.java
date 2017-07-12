package com.iss.dashboard.filter;

import com.iss.dashboard.ApplicationConstants;
import com.iss.dashboard.dto.UserLoginDTO;
import org.jboss.logging.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class AuthenticationFilter implements Filter {
    private static final Logger log = Logger.getLogger(AuthenticationFilter.class);
 
	private boolean isAJAXRequest(HttpServletRequest request) {
		boolean check = false;
		String facesRequest = request.getHeader("Faces-Request");
		if (facesRequest != null && facesRequest.equals("partial/ajax")) {
			check = true;
		}
		return check;
	}

	private String TARGET = "/login.jsf";

	public void doFilter(ServletRequest req, ServletResponse res,FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		HttpSession session = request.getSession(false);
		String redirectURL = response.encodeRedirectURL(request.getContextPath() + TARGET);
		UserLoginDTO user = (session != null) ? (UserLoginDTO) session.getAttribute(ApplicationConstants.USER_LOGIN) : null;
	 	 
		boolean flag = false;
		if (session != null) {
			flag = sessionLogin(session, user);
		} 
			if ((isAJAXRequest(request) && user == null) || (flag==true && isAJAXRequest(request)) ){
				StringBuilder sb = new StringBuilder();
				sb.append(
						"<?xml version=\"1.0\" encoding=\"UTF-8\"?><partial-response><redirect url=\"")
						.append(redirectURL)
						.append("\"></redirect></partial-response>");
				response.setHeader("Cache-Control", "no-cache");
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/xml");
				PrintWriter pw = response.getWriter();
				pw.println(sb.toString());
				pw.flush();
			} else if ((user == null ) || (flag)){
				response.sendRedirect(redirectURL);
			} else {
				chain.doFilter(request, response);
			}
		} 
  
	private boolean sessionLogin(HttpSession session, UserLoginDTO user) {
		 try {
			 
//			    ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(session.getServletContext());
//				IAccountService accountService = (IAccountService) ctx.getBean("accountService");
//
//				String username = user.getUserName();
//				String pin = user.getPin();
//				String sessionn = session.getId();
//
//				ProcessResult proResult = null;
//
//				proResult = accountService.getUserLoginByUserName(username);
//
//				PcUserLoginDTO pcSess = (PcUserLoginDTO) proResult.getObj();
//				String sess = pcSess.getSessionId();
//
////				System.out.print(" session db  	: " + sess);
////				System.out.print(" session now	: " + sessionn);
//
//				if (!StringUtils.equals(sessionn, sess)) {
//					return true;
//				}
		 	
		} catch (Exception e) {
			 e.printStackTrace();
		}
		 return false;
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
	}
	
	public void destroy() {
		// TODO Auto-generated method stub
	}
}
