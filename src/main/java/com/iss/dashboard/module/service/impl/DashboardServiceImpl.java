package com.iss.dashboard.module.service.impl;

import com.iss.dashboard.dto.*;
import com.iss.dashboard.module.service.DashboardServiceInf;
import com.iss.dashboard.module.service.MasterService;
import com.iss.dashboard.utils.DateUtil;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.faces.bean.ApplicationScoped;
import java.util.Date;

/**
 * Created by iWorawut on 12-Feb-17.
 */
@Service("dashboardService")
@ApplicationScoped
public class DashboardServiceImpl extends MasterService implements DashboardServiceInf{
    private static final Logger logger = Logger.getLogger(DashboardServiceImpl.class);

    private static final String RED_COLOR = "#ff0100";
    private static final String GREEN_COLOR = "#66cc33";
    private static final String AMBER_COLOR = "#f0c602";
    @Override
    @Transactional(readOnly=true)
    public ProcessResult getMovement() throws Exception {
        ProcessResult rtnResult = new ProcessResult();
        MovementDto movementDto = new MovementDto();
        rtnResult.setFlag(true);
        //TODO Mock data
        movementDto.setArrival1("30");
        movementDto.setArrival2("12");
        movementDto.setArrival3("12");
        movementDto.setArrival4("10/5");
        movementDto.setArrival5("12/0/1");
        movementDto.setArrival6("16");
        movementDto.setDeparture1("14");
        movementDto.setDeparture2("14");
        movementDto.setDeparture3("14");
        movementDto.setDeparture4("14");
        movementDto.setDeparture5("14");
        movementDto.setDeparture6("14");
        movementDto.setTowing1("2");
        movementDto.setTowing2("3/1");
        movementDto.setTowing3("0");
        movementDto.setTowing4("5");
        movementDto.setTowing5("2");
        movementDto.setTowing6("0");
        //TODO Set Color
        movementDto.setArrival1Color(GREEN_COLOR);
        movementDto.setArrival2Color(GREEN_COLOR);
        movementDto.setArrival3Color(GREEN_COLOR);
        movementDto.setArrival4Color(AMBER_COLOR);
        movementDto.setArrival5Color(RED_COLOR);
        movementDto.setArrival6Color(GREEN_COLOR);
        movementDto.setDeparture1Color(GREEN_COLOR);
        movementDto.setDeparture2Color(GREEN_COLOR);
        movementDto.setDeparture3Color(GREEN_COLOR);
        movementDto.setDeparture4Color(GREEN_COLOR);
        movementDto.setDeparture5Color(GREEN_COLOR);
        movementDto.setDeparture6Color(GREEN_COLOR);
        movementDto.setTowing1Color(GREEN_COLOR);
        movementDto.setTowing2Color(AMBER_COLOR);
        movementDto.setTowing3Color(GREEN_COLOR);
        movementDto.setTowing4Color(GREEN_COLOR);
        movementDto.setTowing5Color(GREEN_COLOR);
        movementDto.setTowing6Color(GREEN_COLOR);
        rtnResult.setObj(movementDto);
        return rtnResult;
    }

    @Override
    @Transactional(readOnly=true)
    public ProcessResult getAirportInfo() throws Exception {
        ProcessResult rtnResult = new ProcessResult();
        AirportInfoDto airportInfoDto = new AirportInfoDto();
        //TODO Mock Data
        airportInfoDto.setRunway1("20C");
        airportInfoDto.setRunway2("20L");
        airportInfoDto.setCapacity1("22");
        airportInfoDto.setCapacity2("22");
        airportInfoDto.setDemand1("5/14");
        airportInfoDto.setDemand2("25/0");
        airportInfoDto.setWeather1("4C");
        airportInfoDto.setWeather2("W-10kts");
        airportInfoDto.setWeather3("Vis 5mi");
        //TODO set color
        airportInfoDto.setRunway1Color(GREEN_COLOR);
        airportInfoDto.setRunway2Color(GREEN_COLOR);
        airportInfoDto.setCapacity1Color(GREEN_COLOR);
        airportInfoDto.setCapacity2Color(GREEN_COLOR);
        airportInfoDto.setDemand1Color(GREEN_COLOR);
        airportInfoDto.setDemand2Color(RED_COLOR);
        airportInfoDto.setWeather1Color(AMBER_COLOR);
        airportInfoDto.setWeather2Color(GREEN_COLOR);
        airportInfoDto.setWeather3Color(GREEN_COLOR);
        rtnResult.setFlag(true);
        rtnResult.setObj(airportInfoDto);
        return rtnResult;
    }

    @Override
    @Transactional(readOnly=true)
    public ProcessResult getFlightProgress() throws Exception {
        ProcessResult rtnResult = new ProcessResult();
        FlightProgressDto flightProgressDto = new FlightProgressDto();
        rtnResult.setFlag(true);
        //TODO Mock Data
        flightProgressDto.setMovementRute("4");
        flightProgressDto.setMovementAldt("3");
        flightProgressDto.setMovementAibt("22");
        flightProgressDto.setMovementTobt("16/2");
        flightProgressDto.setMovementTsat("2");
        flightProgressDto.setMovementAobt("1");
        flightProgressDto.setAlertRute("0");
        flightProgressDto.setAlertAldt("0");
        flightProgressDto.setAlertAibt("4");
        flightProgressDto.setAlertTobt("0");
        flightProgressDto.setAlertTsat("0");
        flightProgressDto.setAlertAobt("0");
        //TODO set color
        flightProgressDto.setMovementRuteColor(GREEN_COLOR);
        flightProgressDto.setMovementAldtColor(GREEN_COLOR);
        flightProgressDto.setMovementAibtColor(GREEN_COLOR);
        flightProgressDto.setMovementTobtColor(RED_COLOR);
        flightProgressDto.setMovementTsatColor(GREEN_COLOR);
        flightProgressDto.setMovementAobtColor(GREEN_COLOR);
        flightProgressDto.setAlertRuteColor(GREEN_COLOR);
        flightProgressDto.setAlertAldtColor(GREEN_COLOR);
        flightProgressDto.setAlertAibtColor(RED_COLOR);
        flightProgressDto.setAlertTobtColor(GREEN_COLOR);
        flightProgressDto.setAlertTsatColor(GREEN_COLOR);
        flightProgressDto.setAlertAobtColor(GREEN_COLOR);
        rtnResult.setObj(flightProgressDto);
        return rtnResult;
    }

    @Override
    @Transactional(readOnly=true)
    public ProcessResult getAlerts() throws Exception {
        ProcessResult rtnResult = new ProcessResult();
        rtnResult.setFlag(true);
        rtnResult.setObj(null);
        return rtnResult;
    }

    @Override
    @Transactional(readOnly=true)
    public ProcessResult getPaxPrm() throws Exception {
        ProcessResult rtnResult = new ProcessResult();
        PaxPrmDto paxPrmDto = new PaxPrmDto();
        //Todo mock data
        paxPrmDto.setInbound1("416/22");
        paxPrmDto.setInbound2("6/9");
        paxPrmDto.setTransfer1("142/86");
        paxPrmDto.setTransfer2("4/9");
        paxPrmDto.setOutbound1("662/112");
        paxPrmDto.setOutbound2("4/9");
        //Todo set color
        paxPrmDto.setInbound1Color(GREEN_COLOR);
        paxPrmDto.setInbound2Color(GREEN_COLOR);
        paxPrmDto.setTransfer1Color(GREEN_COLOR);
        paxPrmDto.setTransfer2Color(GREEN_COLOR);
        paxPrmDto.setOutbound1Color(GREEN_COLOR);
        paxPrmDto.setOutbound2Color(GREEN_COLOR);
        rtnResult.setFlag(true);
        rtnResult.setObj(paxPrmDto);
        return rtnResult;
    }

    @Override
    @Transactional(readOnly=true)
    public ProcessResult getUldBaggage() throws Exception {
        ProcessResult rtnResult = new ProcessResult();
        UldBaggageDto uldBaggageDto = new UldBaggageDto();
        //Todo mock data
        uldBaggageDto.setInbound1("416/22");
        uldBaggageDto.setInbound2("6/9");
        uldBaggageDto.setTransfer1("142/86");
        uldBaggageDto.setTransfer2("4/9");
        uldBaggageDto.setOutbound1("662/112");
        uldBaggageDto.setOutbound2("4/9");
        //Todo set color
        uldBaggageDto.setInbound1Color(GREEN_COLOR);
        uldBaggageDto.setInbound2Color(GREEN_COLOR);
        uldBaggageDto.setTransfer1Color(GREEN_COLOR);
        uldBaggageDto.setTransfer2Color(GREEN_COLOR);
        uldBaggageDto.setOutbound1Color(GREEN_COLOR);
        uldBaggageDto.setOutbound2Color(GREEN_COLOR);
        rtnResult.setFlag(true);
        rtnResult.setObj(uldBaggageDto);
        return rtnResult;
    }

    @Override
    @Transactional(readOnly=true)
    public ProcessResult getQueues() throws Exception {
        ProcessResult rtnResult = new ProcessResult();
        QueuesDto queuesDto = new QueuesDto();
        //Todo mock data
        queuesDto.setTerminal1C("12/16");
        queuesDto.setTerminal1P("6/7");
        queuesDto.setTerminal1S("2/5");
        queuesDto.setTerminal2C("12/22");
        queuesDto.setTerminal2P("4/9");
        queuesDto.setTerminal2S("5/4");
        queuesDto.setTerminal3C("12/22");
        queuesDto.setTerminal3P("4/9");
        queuesDto.setTerminal3S("8/4");
        //Todo set color
        queuesDto.setTerminal1CColor(RED_COLOR);
        queuesDto.setTerminal1PColor(AMBER_COLOR);
        queuesDto.setTerminal1SColor(GREEN_COLOR);
        queuesDto.setTerminal2CColor(GREEN_COLOR);
        queuesDto.setTerminal2PColor(GREEN_COLOR);
        queuesDto.setTerminal2SColor(GREEN_COLOR);
        queuesDto.setTerminal3CColor(GREEN_COLOR);
        queuesDto.setTerminal3PColor(GREEN_COLOR);
        queuesDto.setTerminal3SColor(GREEN_COLOR);
        rtnResult.setFlag(true);
        rtnResult.setObj(queuesDto);
        return rtnResult;
    }

    @Override
    @Transactional(readOnly=true)
    public ProcessResult getCriticalResources() throws Exception {
        ProcessResult rtnResult = new ProcessResult();
        CriticalResourceDto criticalResourceDto = new CriticalResourceDto();
        //Todo mock data
        criticalResourceDto.setStand1("16/22");
        criticalResourceDto.setStand2("6/9");
        criticalResourceDto.setStand3("2/4");
        criticalResourceDto.setStand4("6/7");
        criticalResourceDto.setStand5("2/5");
        criticalResourceDto.setStand6("16/18");
        criticalResourceDto.setBelt1("30/32");
        criticalResourceDto.setBelt2("12/32");
        criticalResourceDto.setBelt3("12/32");
        criticalResourceDto.setBelt4("12/32");
        criticalResourceDto.setBelt5("13/10");
        criticalResourceDto.setBelt6("16/16");
        criticalResourceDto.setDeLcing1("12/22");
        criticalResourceDto.setDeLcing2("4/9");
        criticalResourceDto.setDeLcing3("0/4");
        criticalResourceDto.setDeLcing4("2/6");
        criticalResourceDto.setDeLcing5("8/5");
        criticalResourceDto.setDeLcing6("12/16");
        criticalResourceDto.setPushBack1("12/22");
        criticalResourceDto.setPushBack2("4/9");
        criticalResourceDto.setPushBack3("0/4");
        criticalResourceDto.setPushBack4("2/6");
        criticalResourceDto.setPushBack5("10/5");
        criticalResourceDto.setPushBack6("12/16");
        //Todo set color
        criticalResourceDto.setStand1Color(GREEN_COLOR);
        criticalResourceDto.setStand2Color(GREEN_COLOR);
        criticalResourceDto.setStand3Color(GREEN_COLOR);
        criticalResourceDto.setStand4Color(AMBER_COLOR);
        criticalResourceDto.setStand5Color(GREEN_COLOR);
        criticalResourceDto.setStand6Color(GREEN_COLOR);
        criticalResourceDto.setBelt1Color(GREEN_COLOR);
        criticalResourceDto.setBelt2Color(GREEN_COLOR);
        criticalResourceDto.setBelt3Color(GREEN_COLOR);
        criticalResourceDto.setBelt4Color(GREEN_COLOR);
        criticalResourceDto.setBelt5Color(RED_COLOR);
        criticalResourceDto.setBelt6Color(AMBER_COLOR);
        criticalResourceDto.setDeLcing1Color(GREEN_COLOR);
        criticalResourceDto.setDeLcing2Color(GREEN_COLOR);
        criticalResourceDto.setDeLcing3Color(GREEN_COLOR);
        criticalResourceDto.setDeLcing4Color(GREEN_COLOR);
        criticalResourceDto.setDeLcing5Color(RED_COLOR);
        criticalResourceDto.setDeLcing6Color(GREEN_COLOR);
        criticalResourceDto.setPushBack1Color(GREEN_COLOR);
        criticalResourceDto.setPushBack2Color(GREEN_COLOR);
        criticalResourceDto.setPushBack3Color(GREEN_COLOR);
        criticalResourceDto.setPushBack4Color(GREEN_COLOR);
        criticalResourceDto.setPushBack5Color(RED_COLOR);
        criticalResourceDto.setPushBack6Color(GREEN_COLOR);
        rtnResult.setFlag(true);
        rtnResult.setObj(criticalResourceDto);
        return rtnResult;
    }

    @Override
    @Transactional(readOnly=true)
    public ProcessResult getOpsFlash() throws Exception {
        ProcessResult rtnResult = new ProcessResult();
        OpsFlashDto opsFlashDto = new OpsFlashDto();
        //Todo mock data
        opsFlashDto.setDescription1("Priority Landing SQ521 (Medical)");
        opsFlashDto.setDate1(DateUtil.convertDateToString(new Date(),DateUtil.DATE_DASHBOARD_FORMAT)+" - AOCC");
        opsFlashDto.setDescription2("Runway Inspection 20C - 1300-1315");
        opsFlashDto.setDate2(DateUtil.convertDateToString(new Date(),DateUtil.DATE_DASHBOARD_FORMAT)+" - NOTAM");
        opsFlashDto.setDescription3("Weather Forecast - Snow after 3pm");
        opsFlashDto.setDate3(DateUtil.convertDateToString(new Date(),DateUtil.DATE_DASHBOARD_FORMAT)+" - METAR");
        rtnResult.setFlag(true);
        rtnResult.setObj(opsFlashDto);
        return rtnResult;
    }
}
