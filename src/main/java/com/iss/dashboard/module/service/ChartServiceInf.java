package com.iss.dashboard.module.service;

import com.iss.dashboard.dto.ProcessResult;

/**
 * Created by iWorawut on 13-Feb-17.
 */
public interface ChartServiceInf {
    public ProcessResult getArrivalPerformance()throws Exception;
    public ProcessResult getPaxCondition()throws Exception;
    public ProcessResult getLoadFactor()throws Exception;
    public ProcessResult getDeparturePerformance()throws Exception;
    public ProcessResult getBagCondition()throws Exception;
    public ProcessResult getDepartureDelay()throws Exception;
    public ProcessResult getTopMisReport()throws Exception;
}
