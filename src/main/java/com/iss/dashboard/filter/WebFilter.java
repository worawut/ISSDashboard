package com.iss.dashboard.filter;

import org.jboss.logging.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WebFilter implements Filter {
    private static final Logger log = Logger.getLogger(WebFilter.class);
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	private String TARGET = "/login.jsf";
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		   HttpServletRequest httpReq = (HttpServletRequest) request;
	       HttpServletResponse httpRes = (HttpServletResponse) response;
	        
	       //log.info("getRequestURI: " + httpReq.getRequestURI());
	       
	       if (httpReq.getRequestURI().endsWith("web.xml.jsf")) { 
	    		String redirectURL = httpRes.encodeRedirectURL(httpReq.getContextPath() + TARGET);
	    		httpRes.sendRedirect(redirectURL);
	       }else {
	    	   chain.doFilter(httpReq, httpRes);
	       } 
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
