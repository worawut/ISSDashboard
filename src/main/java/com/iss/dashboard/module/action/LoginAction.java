package com.iss.dashboard.module.action;

import com.iss.dashboard.ApplicationConstants;
import com.iss.dashboard.config.SessionBean;
import com.iss.dashboard.dto.ProcessResult;
import com.iss.dashboard.dto.UserLoginDTO;
import com.iss.dashboard.module.service.LoginServiceInf;
import org.apache.commons.lang3.StringUtils;
import org.jboss.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 * Created by iWorawut on 29-Oct-16.
 */
@ManagedBean(name = "loginAction")
@ViewScoped
public class LoginAction extends BaseAction {

    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(LoginAction.class);

    private String username;
    private String password;
    private String availWidth;
    private String availHeight;

    @ManagedProperty("#{loginService}")
    private LoginServiceInf loginService;

    @Override
    @PostConstruct
    public void initAction(){
        logger.info("initLoginAction:Begin");
        try {
            super.destroySessionAll();
            username = StringUtils.EMPTY;
            password= StringUtils.EMPTY;
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("initLoginAction:End");
    }

    @Override
    @PreDestroy
    public void destroy() {
        username = StringUtils.EMPTY;
        password= StringUtils.EMPTY;
    }

    public String login() throws Exception {
        logger.info("login:Begin");
        logger.info("User:"+this.username);
        logger.info("Password:"+this.password);
        logger.info("## Username: " + this.username);
        ProcessResult proResult = loginService.login(this.username,this.password);
        if(proResult.isFlag()){
            logger.info("=========>> Login System Success !! ");
            UserLoginDTO userLogin = (UserLoginDTO) proResult.getObj();
            logger.info(" UserLoginDTO " + userLogin.toString() );

            //Create Session
            logger.info("=========>> Create Login Session.");
//            userLogin.setIpAddress(getClientIpAddress());
            super.aadSession(userLogin, ApplicationConstants.USER_LOGIN);

            SessionBean sessionBean =  new SessionBean();
            sessionBean.setUserLogin(userLogin);
//            sessionBean.setAdmin(userLogin.isAdmin());
            sessionBean.setAvailWidth(availWidth);
            sessionBean.setAvailHeight(availHeight);
            super.setSessionBean(sessionBean);

            return redirect("pages/" + ApplicationConstants.ApplicationPages.HOME);
        }
        logger.info("login:End");
        return null;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public LoginServiceInf getLoginService() {
        return loginService;
    }

    public void setLoginService(LoginServiceInf loginService) {
        this.loginService = loginService;
    }
}
