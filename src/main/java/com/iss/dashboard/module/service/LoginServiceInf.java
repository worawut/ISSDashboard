package com.iss.dashboard.module.service;

import com.iss.dashboard.dto.ProcessResult;

/**
 * Created by iWorawut on 20-Nov-16.
 */
public interface LoginServiceInf {
    public ProcessResult login(String username, String password)throws Exception;
}
