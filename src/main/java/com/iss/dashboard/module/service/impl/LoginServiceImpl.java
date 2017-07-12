package com.iss.dashboard.module.service.impl;

import com.iss.dashboard.dto.ProcessResult;
import com.iss.dashboard.dto.UserLoginDTO;
import com.iss.dashboard.module.service.LoginServiceInf;
import com.iss.dashboard.module.service.MasterService;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Service;

import javax.faces.bean.ApplicationScoped;

/**
 * Created by iWorawut on 20-Nov-16.
 */
@Service("loginService")
@ApplicationScoped
public class LoginServiceImpl extends MasterService implements LoginServiceInf{
    private static final Logger logger = Logger.getLogger(LoginServiceImpl.class);

    @Override
    public ProcessResult login(String username, String password) throws Exception {
        logger.info("login:Begin");
        ProcessResult result = new ProcessResult();
        UserLoginDTO userLogin = new UserLoginDTO();
        userLogin.setUserName(username);
        userLogin.setBuildNo("Build 01");
        userLogin.setHomeAirport("Donmuang International Airport");
        result.setObj(userLogin);
        result.setFlag(true);
        logger.info("login:End");
        return result;
    }
}
