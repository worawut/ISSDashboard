package com.iss.dashboard.filter;

import com.iss.dashboard.ApplicationConstants;
import com.iss.dashboard.dto.UserLoginDTO;
import org.jboss.logging.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class GeneralFilter implements Filter {
    private static final Logger log = Logger.getLogger(GeneralFilter.class);
    
	@Override
	public void destroy() { 
	}
	
	private String TARGET = "/access-denied.jsf";
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		   HttpServletRequest httpReq = (HttpServletRequest) request;
	       HttpServletResponse httpRes = (HttpServletResponse) response;
	       HttpSession session = httpReq.getSession(false);
	       UserLoginDTO user = (session != null) ? (UserLoginDTO) session.getAttribute(ApplicationConstants.USER_LOGIN) : null;

			if(user!=null){
			   chain.doFilter(httpReq, httpRes);
	       }
	        
	}
 
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
