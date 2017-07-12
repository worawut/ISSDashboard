package com.iss.dashboard.module.service;

import com.iss.dashboard.dto.ProcessResult;

/**
 * Created by iWorawut on 12-Feb-17.
 */
public interface DashboardServiceInf {
    public ProcessResult getMovement()throws Exception;
    public ProcessResult getAirportInfo()throws Exception;
    public ProcessResult getFlightProgress()throws Exception;
    public ProcessResult getAlerts()throws Exception;
    public ProcessResult getPaxPrm()throws Exception;
    public ProcessResult getUldBaggage()throws Exception;
    public ProcessResult getQueues()throws Exception;
    public ProcessResult getCriticalResources()throws Exception;
    public ProcessResult getOpsFlash()throws Exception;
}
