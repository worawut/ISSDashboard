package com.iss.dashboard.config;

import com.iss.dashboard.dto.ProcessResult;
import com.iss.dashboard.dto.UserLoginDTO;
import org.jboss.logging.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Locale;

@ManagedBean
@SessionScoped
public class SessionBean implements java.io.Serializable {

	private static Locale locale = new Locale("en", "US");
	static {
		Locale.setDefault(locale);
	}

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(SessionBean.class);
	private String availWidth;
	private String availHeight;

	private UserLoginDTO userLogin;

	private String fullName;
	private boolean admin;
	private ProcessResult result;

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getFullName() {
		String fName = userLogin.getFirstNameThai();
		String lName = userLogin.getLastNameThai();
		this.fullName = fName + " " + lName;
		return fullName;
	}

	public void logout() {
		try {
			logger.info("-------------- logout ---------------");
			FacesContext facesContext = FacesContext.getCurrentInstance();
			HttpSession httpSession = (HttpSession) facesContext.getExternalContext().getSession(false);
			httpSession.invalidate();
		} catch (Exception e) {

		}
	}

	public void keepSessionAlive() {
		logger.info("-------------- keepSessionAlive ---------------");
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) fc.getExternalContext().getRequest();
		request.getSession();

	}

	/*public String destroySessionBean() {
		logger.info("Destroy Session Bean");
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		String pageMenu = (String) context.getRequestParameterMap().get("pageMenu");
		context.getSessionMap().remove(ApplicationConstants.MSessionBean.PCM001Action);
		context.getSessionMap().remove(ApplicationConstants.MSessionBean.PCM002Action);
		context.getSessionMap().remove(ApplicationConstants.MSessionBean.PCM005Action);
		context.getSessionMap().remove(ApplicationConstants.MSessionBean.PCM006Action);
		context.getSessionMap().remove(ApplicationConstants.MSessionBean.PCMAssetHandOverAction);
		logger.info("Return Page : " + pageMenu);

		return ApplicationUtils.redirect(pageMenu);
	}*/

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public ProcessResult getResult() {
		return result;
	}

	public void setResult(ProcessResult result) {
		this.result = result;
	}

	public String getAvailWidth() {
		return availWidth;
	}

	public void setAvailWidth(String availWidth) {
		this.availWidth = availWidth;
	}

	public String getAvailHeight() {
		return availHeight;
	}

	public void setAvailHeight(String availHeight) {
		this.availHeight = availHeight;
	}

	public UserLoginDTO getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(UserLoginDTO userLogin) {
		this.userLogin = userLogin;
	}
}
