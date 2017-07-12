package com.iss.dashboard.listeners;

import org.jboss.logging.Logger;

import javax.faces.FacesException;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class PageNavigationListener implements PhaseListener {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(PageNavigationListener.class);
	String HOME_PAGE = "../login";

	public void afterPhase(PhaseEvent event) {
		   FacesContext facesCtx = event.getFacesContext();
	        ExternalContext extCtx = facesCtx .getExternalContext();
	        HttpServletRequest request = (HttpServletRequest) facesCtx.getExternalContext().getRequest();
	        @SuppressWarnings("unused")
			HttpSession session = (HttpSession) extCtx .getSession(false); 
	        
	        String originalURL = request.getRequestURL().toString();
	        String loginURL = request.getContextPath() + "/login.jsf";
	        String originalURI = request.getRequestURI();
	        logger.debug("originalURL " + originalURL);
	        logger.debug("originalURI " + originalURI);
	        logger.debug("loginURL " + loginURL);
	         
	}

	public void beforePhase(PhaseEvent event) {
		logger.debug("START PHASE " + event.getPhaseId());
        FacesContext facesCtx = event.getFacesContext();
        ExternalContext extCtx = facesCtx .getExternalContext();
        HttpServletRequest request = (HttpServletRequest) facesCtx.getExternalContext().getRequest();
        HttpSession session = (HttpSession) extCtx .getSession(false); 
        
        String originalURL = request.getRequestURL().toString();
        String loginURL = request.getContextPath() + "/login.jsf";
        String originalURI = request.getRequestURI();
        logger.debug("originalURL " + originalURL);
        logger.debug("originalURI " + originalURI);
        logger.debug("loginURL " + loginURL);
        
        boolean loginPage = loginURL.equals(request.getRequestURI());
        boolean newSession = (session == null) || (session.isNew()); 
        boolean postback = !extCtx.getRequestParameterMap().isEmpty();
       // boolean timedout = postback && newSession && !loginPage; 
        boolean timedout =  newSession && !loginPage; 
        
        logger.debug("loginPage " + loginPage);
        logger.debug("newSession " + newSession);
        logger.debug("postback " + postback);
        logger.debug("timedout " + timedout);
 
      
        
        
        // invoke login page.
        if(loginPage){
        	 Application app = facesCtx.getApplication(); 
             ViewHandler viewHandler = app.getViewHandler();
             UIViewRoot view = viewHandler.createView( facesCtx, "/login"); 
             facesCtx.setViewRoot(view); 
             facesCtx.renderResponse(); 
             try { 
                 viewHandler.renderView(facesCtx, view); 
                 facesCtx.responseComplete(); 
              } catch(Throwable t) { 
                 throw new FacesException( "Session timed out", t); 
              } 
        	
        	 
        }
        // invoke etc page and check timeout.
        else if(timedout) { 
           logger.debug(" Session Time out do redirect to /login.xhtml ");
           Application app = facesCtx.getApplication(); 
           ViewHandler viewHandler = app.getViewHandler();
           facesCtx.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Session Time Out !", ""));
           UIViewRoot view = viewHandler.createView( facesCtx, "/login"); 
           facesCtx.setViewRoot(view); 
           facesCtx.renderResponse(); 
           try { 
              viewHandler.renderView(facesCtx, view); 
              facesCtx.responseComplete(); 
           } catch(Throwable t) { 
              throw new FacesException( "Session timed out", t); 
           } 
        }
	}

	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;

	}
 
}
