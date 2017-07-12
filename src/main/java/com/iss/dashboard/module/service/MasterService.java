package com.iss.dashboard.module.service;

import com.iss.dashboard.ApplicationConstants;
import com.iss.dashboard.dto.UserLoginDTO;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.util.Map;

public abstract class MasterService implements java.io.Serializable {
 
	private static final long serialVersionUID = 1L;
	
// 	@Value("${security.ldap.enable}")
//	public boolean LDAP_ENABLE;
	 
	public String getUserNameLogin(){
		FacesContext context = FacesContext.getCurrentInstance();
		UserLoginDTO userLoginDTO =  (UserLoginDTO) context.getExternalContext().getSessionMap().get(ApplicationConstants.USER_LOGIN);
		if(userLoginDTO!=null){
			return userLoginDTO.getUserName();
		}
		return "SYSTEM";
	}
	
	public UserLoginDTO getUserLogin() {
		FacesContext context = FacesContext.getCurrentInstance();
		return (UserLoginDTO) context.getExternalContext().getSessionMap().get(ApplicationConstants.USER_LOGIN);
	}

	public void aadSession(Object obj, String sessionName) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(sessionName, obj);
	}

	public String getParam(String param) {
		Map<String, String> params = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap();
		String action = params.get(param);
		return action;
	}
	public String getSesstionId() {
		FacesContext fCtx = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fCtx.getExternalContext().getSession(false);
		String sessionId = session.getId();
		return sessionId;
	}
 



}
