package com.iss.dashboard.module.action;

import com.iss.dashboard.ApplicationConstants;
import com.iss.dashboard.dto.*;
import com.iss.dashboard.module.service.ChartServiceInf;
import com.iss.dashboard.module.service.DashboardServiceInf;
import com.iss.dashboard.utils.DateUtil;
import org.jboss.logging.Logger;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.HorizontalBarChartModel;
import org.primefaces.model.chart.LineChartModel;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.util.Date;
import java.util.List;

/**
 * Created by iWorawut on 20-Nov-16.
 */
@ManagedBean(name = "homeAction")
@ViewScoped
public class HomeAction extends BaseAction {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(HomeAction.class);
    private static final String PAGES_PATH = "pages/";

    private String dashboardDate;

    @ManagedProperty("#{dashboardService}")
    private DashboardServiceInf dashboardService;
    @ManagedProperty("#{chartService}")
    private ChartServiceInf chartServiceInf;

    private MovementDto movementDto;
    private AirportInfoDto airportInfoDto;
    private FlightProgressDto flightProgressDto;
    private AlertsDto alertsDto;
    private PaxPrmDto paxPrmDto;
    private UldBaggageDto uldBaggageDto;
    private QueuesDto queuesDto;
    private CriticalResourceDto criticalResourceDto;
    private OpsFlashDto opsFlashDto;

    private LineChartModel arrivalPerformanceModel;
    private LineChartModel departurePerformanceModel;
    private HorizontalBarChartModel horizontalPaxBarModel;
    private BarChartModel loadFactorBarModel;
    private HorizontalBarChartModel horizontalBagBarModel;
    private HorizontalBarChartModel departureDelayBarModel;
    private List<TopMisConnectDto> topMisList;

    @PostConstruct
    @Override
    public void initAction(){
        logger.info("initAction");
        try {
            this.initCharts();
            this.updateDashboardDate();
            this.updateMovement();
            this.updateAirport();
            this.updateFlightProgress();
            this.updateAlerts();
            this.updatePaxPrm();
            this.updateUldBaggage();
            this.updateQueues();
            this.updateCriticalResources();
            this.updateOpsFlash();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    @PreDestroy
    public void destroy() {

    }

    public void initCharts()throws Exception{
        ProcessResult rtnResult = chartServiceInf.getArrivalPerformance();
        if(rtnResult.isFlag())
            arrivalPerformanceModel = (LineChartModel) rtnResult.getObj();

        rtnResult = chartServiceInf.getPaxCondition();
        if(rtnResult.isFlag())
            horizontalPaxBarModel = (HorizontalBarChartModel) rtnResult.getObj();

        rtnResult = chartServiceInf.getLoadFactor();
        if(rtnResult.isFlag())
            loadFactorBarModel = (BarChartModel) rtnResult.getObj();

        rtnResult = chartServiceInf.getDeparturePerformance();
        if(rtnResult.isFlag())
            departurePerformanceModel = (LineChartModel) rtnResult.getObj();

        rtnResult = chartServiceInf.getBagCondition();
        if(rtnResult.isFlag())
            horizontalBagBarModel = (HorizontalBarChartModel) rtnResult.getObj();

        rtnResult = chartServiceInf.getDepartureDelay();
        if(rtnResult.isFlag())
            departureDelayBarModel = (HorizontalBarChartModel) rtnResult.getObj();

        rtnResult = chartServiceInf.getTopMisReport();
        if(rtnResult.isFlag())
            topMisList = (List<TopMisConnectDto>) rtnResult.getObj();
    }

    public String updateDashboardDate()throws Exception{
        dashboardDate = DateUtil.convertDateToString(new Date(),DateUtil.DATE_DASHBOARD_FORMAT);
        return "";
    }

    public String updateEvery5minute()throws Exception{
        this.updateMovement();
        this.updateAirport();
        this.updatePaxPrm();
        this.updateUldBaggage();
        this.updateQueues();
        this.updateCriticalResources();
        return "";
    }

    public String updateEvery1minute()throws Exception{
        this.updateFlightProgress();
        return "";
    }

    public void updateMovement()throws Exception{
        ProcessResult processResult = dashboardService.getMovement();
        if(processResult.isFlag())
            movementDto = (MovementDto) processResult.getObj();
    }

    public void updateAirport()throws Exception{
        ProcessResult processResult = dashboardService.getAirportInfo();
        if(processResult.isFlag())
            airportInfoDto = (AirportInfoDto) processResult.getObj();
    }

    public void updateFlightProgress()throws Exception{
        ProcessResult processResult = dashboardService.getFlightProgress();
        if(processResult.isFlag())
            flightProgressDto = (FlightProgressDto) processResult.getObj();
    }

    public void updateAlerts()throws Exception{
        ProcessResult processResult = dashboardService.getAlerts();
        if(processResult.isFlag())
            alertsDto = (AlertsDto) processResult.getObj();
    }

    public void updatePaxPrm()throws Exception{
        ProcessResult processResult = dashboardService.getPaxPrm();
        if(processResult.isFlag())
            paxPrmDto = (PaxPrmDto) processResult.getObj();
    }

    public void updateUldBaggage()throws Exception{
        ProcessResult processResult = dashboardService.getUldBaggage();
        if(processResult.isFlag())
            uldBaggageDto = (UldBaggageDto) processResult.getObj();
    }

    public void updateQueues()throws Exception{
        ProcessResult processResult = dashboardService.getQueues();
        if(processResult.isFlag())
            queuesDto = (QueuesDto) processResult.getObj();
    }

    public void updateCriticalResources()throws Exception{
        ProcessResult processResult = dashboardService.getCriticalResources();
        if(processResult.isFlag())
            criticalResourceDto = (CriticalResourceDto) processResult.getObj();
    }

    public void updateOpsFlash()throws Exception{
        ProcessResult processResult = dashboardService.getOpsFlash();
        if(processResult.isFlag())
            opsFlashDto = (OpsFlashDto) processResult.getObj();
    }

    public String getDashboardDate() {
        return dashboardDate;
    }

    public void setDashboardDate(String dashboardDate) {
        this.dashboardDate = dashboardDate;
    }

    public DashboardServiceInf getDashboardService() {
        return dashboardService;
    }

    public void setDashboardService(DashboardServiceInf dashboardService) {
        this.dashboardService = dashboardService;
    }

    public MovementDto getMovementDto() {
        return movementDto;
    }

    public void setMovementDto(MovementDto movementDto) {
        this.movementDto = movementDto;
    }

    public AirportInfoDto getAirportInfoDto() {
        return airportInfoDto;
    }

    public void setAirportInfoDto(AirportInfoDto airportInfoDto) {
        this.airportInfoDto = airportInfoDto;
    }

    public FlightProgressDto getFlightProgressDto() {
        return flightProgressDto;
    }

    public void setFlightProgressDto(FlightProgressDto flightProgressDto) {
        this.flightProgressDto = flightProgressDto;
    }

    public AlertsDto getAlertsDto() {
        return alertsDto;
    }

    public void setAlertsDto(AlertsDto alertsDto) {
        this.alertsDto = alertsDto;
    }

    public PaxPrmDto getPaxPrmDto() {
        return paxPrmDto;
    }

    public void setPaxPrmDto(PaxPrmDto paxPrmDto) {
        this.paxPrmDto = paxPrmDto;
    }

    public UldBaggageDto getUldBaggageDto() {
        return uldBaggageDto;
    }

    public void setUldBaggageDto(UldBaggageDto uldBaggageDto) {
        this.uldBaggageDto = uldBaggageDto;
    }

    public QueuesDto getQueuesDto() {
        return queuesDto;
    }

    public void setQueuesDto(QueuesDto queuesDto) {
        this.queuesDto = queuesDto;
    }

    public CriticalResourceDto getCriticalResourceDto() {
        return criticalResourceDto;
    }

    public void setCriticalResourceDto(CriticalResourceDto criticalResourceDto) {
        this.criticalResourceDto = criticalResourceDto;
    }

    public OpsFlashDto getOpsFlashDto() {
        return opsFlashDto;
    }

    public void setOpsFlashDto(OpsFlashDto opsFlashDto) {
        this.opsFlashDto = opsFlashDto;
    }

    public ChartServiceInf getChartServiceInf() {
        return chartServiceInf;
    }

    public void setChartServiceInf(ChartServiceInf chartServiceInf) {
        this.chartServiceInf = chartServiceInf;
    }

    public LineChartModel getArrivalPerformanceModel() {
        return arrivalPerformanceModel;
    }

    public void setArrivalPerformanceModel(LineChartModel arrivalPerformanceModel) {
        this.arrivalPerformanceModel = arrivalPerformanceModel;
    }

    public LineChartModel getDeparturePerformanceModel() {
        return departurePerformanceModel;
    }

    public void setDeparturePerformanceModel(LineChartModel departurePerformanceModel) {
        this.departurePerformanceModel = departurePerformanceModel;
    }

    public HorizontalBarChartModel getHorizontalPaxBarModel() {
        return horizontalPaxBarModel;
    }

    public void setHorizontalPaxBarModel(HorizontalBarChartModel horizontalPaxBarModel) {
        this.horizontalPaxBarModel = horizontalPaxBarModel;
    }

    public BarChartModel getLoadFactorBarModel() {
        return loadFactorBarModel;
    }

    public void setLoadFactorBarModel(BarChartModel loadFactorBarModel) {
        this.loadFactorBarModel = loadFactorBarModel;
    }

    public HorizontalBarChartModel getHorizontalBagBarModel() {
        return horizontalBagBarModel;
    }

    public void setHorizontalBagBarModel(HorizontalBarChartModel horizontalBagBarModel) {
        this.horizontalBagBarModel = horizontalBagBarModel;
    }

    public HorizontalBarChartModel getDepartureDelayBarModel() {
        return departureDelayBarModel;
    }

    public void setDepartureDelayBarModel(HorizontalBarChartModel departureDelayBarModel) {
        this.departureDelayBarModel = departureDelayBarModel;
    }

    public List<TopMisConnectDto> getTopMisList() {
        return topMisList;
    }

    public void setTopMisList(List<TopMisConnectDto> topMisList) {
        this.topMisList = topMisList;
    }
}
