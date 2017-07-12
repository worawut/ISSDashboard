package com.iss.dashboard.module.service.impl;

import com.iss.dashboard.dto.ProcessResult;
import com.iss.dashboard.dto.TopMisConnectDto;
import com.iss.dashboard.module.service.ChartServiceInf;
import com.iss.dashboard.module.service.MasterService;
import org.jboss.logging.Logger;
import org.primefaces.model.chart.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.faces.bean.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by iWorawut on 13-Feb-17.
 */
@Service("chartService")
@ApplicationScoped
public class ChartServiceImpl extends MasterService implements ChartServiceInf{
    private static final Logger logger = Logger.getLogger(DashboardServiceImpl.class);

    @Override
    @Transactional(readOnly=true)
    public ProcessResult getArrivalPerformance() throws Exception {
        ProcessResult rtnResult = new ProcessResult();
        LineChartModel arrivalPerformanceModel = new LineChartModel();
        arrivalPerformanceModel.setTitle("Arrival Performance");
        arrivalPerformanceModel.setLegendPosition("e");
        arrivalPerformanceModel.setSeriesColors("0000e6,ff3300,ff3300");
        Axis yAxis = arrivalPerformanceModel.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(50);
        LineChartSeries average = new LineChartSeries();
        average.setShowMarker(false);
        average.setLabel("Average");
        average.set("16:00", 35);
        average.set("17:00", 38);
        average.set("18:00", 36);
        average.set("19:00", 46);
        average.set("20:00", 44);
        average.set("21:00", 47);
        arrivalPerformanceModel.addSeries(average);

        LineChartSeries currentTime = new LineChartSeries();
        currentTime.setShowMarker(false);
        currentTime.setLabel("Time 21.00");
        currentTime.set("21:00", 50);
        currentTime.set("21:00:01",0);
        arrivalPerformanceModel.addSeries(currentTime);

        LineChartSeries flight = new LineChartSeries();
        flight.setShowLine(false);
        flight.setLabel("Departure Flight");
        flight.setMarkerStyle("dash");
        flight.set("16:00", 45);
        flight.set("16:30", 45);
        flight.set("17:00", 45);
        flight.set("17:30", 45);
        flight.set("18:00", 45);
        flight.set("18:30", 45);
        flight.set("19:00", 45);
        flight.set("19:30", 45);
        flight.set("20:00", 45);
        flight.set("20:30", 45);
        flight.set("21:00", 45);
        arrivalPerformanceModel.addSeries(flight);

        DateAxis axis = new DateAxis();
        axis.setTickAngle(-50);
        axis.setMin("15:00");
        axis.setMax("22:00");
        axis.setTickFormat("%H:%#M");
        arrivalPerformanceModel.getAxes().put(AxisType.X, axis);

        rtnResult.setFlag(true);
        rtnResult.setObj(arrivalPerformanceModel);
        return rtnResult;
    }

    @Override
    public ProcessResult getPaxCondition() throws Exception {
        ProcessResult rtnResult = new ProcessResult();
        HorizontalBarChartModel paxConditionModel = new HorizontalBarChartModel();
        paxConditionModel.setTitle("Pax Connection(+2.5hrs)");
        paxConditionModel.setSeriesColors("0000e6,ff3300");
        paxConditionModel.setShowPointLabels(true);
        paxConditionModel.setShowDatatip(false);
        paxConditionModel.setStacked(true);

        ChartSeries main = new ChartSeries();
        main.set("Msconnection", 0);
        main.set("<75 min", 368);
        main.set("75-90 min", 420);
        main.set("90-105 min", 126);
        main.set(">105 min", 284);

        ChartSeries sub = new ChartSeries();
        sub.set("Msconnection", 120);
        sub.set("<75 min",0);
        sub.set("75-90 min", 0);
        sub.set("90-105 min", 0);
        sub.set(">105 min", 0);

        paxConditionModel.addSeries(main);
        paxConditionModel.addSeries(sub);

        rtnResult.setFlag(true);
        rtnResult.setObj(paxConditionModel);
        return rtnResult;
    }

    @Override
    public ProcessResult getLoadFactor() throws Exception {
        ProcessResult rtnResult = new ProcessResult();
        BarChartModel model = new BarChartModel();
        model.setTitle("Load Factor");
        model.setSeriesColors("0000e6,ff3300");
        model.setShowDatatip(false);
        model.setStacked(true);
        model.setShowPointLabels(true);
        model.setBarMargin(60);

        ChartSeries firstBar = new ChartSeries();
        firstBar.set("Arrival", 79);
        firstBar.set("Departure", 69);
        firstBar.set("International", 87);
        firstBar.set("Domestic", 92);
        firstBar.set("Airport", 88);

        ChartSeries secondBar = new ChartSeries();
        secondBar.set("Arrival", 21);
        secondBar.set("Departure", 31);
        secondBar.set("International", 13);
        secondBar.set("Domestic", 8);
        secondBar.set("Airport", 12);

        model.addSeries(firstBar);
        model.addSeries(secondBar);


        Axis axis = new CategoryAxis();
        axis.setTickAngle(-50);
        model.getAxes().put(AxisType.X, axis);

        rtnResult.setFlag(true);
        rtnResult.setObj(model);
        return rtnResult;
    }

    @Override
    @Transactional(readOnly=true)
    public ProcessResult getDeparturePerformance() throws Exception {
        ProcessResult rtnResult = new ProcessResult();
        LineChartModel departureModel = new LineChartModel();
        departureModel.setTitle("Departure Performance");
        departureModel.setLegendPosition("e");
        departureModel.setSeriesColors("0000e6,ff3300,ff3300");
        Axis yAxis = departureModel.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(50);

        LineChartSeries average = new LineChartSeries();
        average.setShowMarker(false);
        average.setLabel("Average");
        average.set("16:00", 39);
        average.set("17:00", 42);
        average.set("18:00", 40);
        average.set("19:00", 43);
        average.set("20:00", 41);
        average.set("21:00", 45);
        departureModel.addSeries(average);

        LineChartSeries currentTime = new LineChartSeries();
        currentTime.setShowMarker(false);
        currentTime.setLabel("Time 21.00");
        currentTime.set("21:00", 50);
        currentTime.set("21:00:01", 0);
        departureModel.addSeries(currentTime);

        LineChartSeries flight = new LineChartSeries();
        flight.setShowLine(false);
        flight.setLabel("Departure Flight");
        flight.setMarkerStyle("dash");
        flight.set("16:00", 45);
        flight.set("16:30", 45);
        flight.set("17:00", 45);
        flight.set("17:30", 45);
        flight.set("18:00", 45);
        flight.set("18:30", 45);
        flight.set("19:00", 45);
        flight.set("19:30", 45);
        flight.set("20:00", 45);
        flight.set("20:30", 45);
        flight.set("21:00", 45);
        departureModel.addSeries(flight);

        DateAxis axis = new DateAxis();
        axis.setTickAngle(-50);
        axis.setMin("15:00");
        axis.setMax("22:00");
        axis.setTickFormat("%H:%#M");
        departureModel.getAxes().put(AxisType.X, axis);

        rtnResult.setFlag(true);
        rtnResult.setObj(departureModel);
        return rtnResult;
    }

    @Override
    public ProcessResult getBagCondition() throws Exception {
        ProcessResult rtnResult = new ProcessResult();
        HorizontalBarChartModel bagConditionModel = new HorizontalBarChartModel();
        bagConditionModel.setTitle("Bag Connection(+2.5hrs)");
        bagConditionModel.setSeriesColors("0000e6,ff3300");
        bagConditionModel.setShowPointLabels(true);
        bagConditionModel.setShowDatatip(false);
        bagConditionModel.setStacked(true);

        ChartSeries series = new ChartSeries();
        series.set("<40 min", 736);
        series.set("40-75 min", 1050);
        series.set("75-90 min", 378);
        series.set("90-105 min", 852);
        series.set(">105 min", 1400);

        bagConditionModel.addSeries(series);

        rtnResult.setFlag(true);
        rtnResult.setObj(bagConditionModel);
        return rtnResult;
    }

    @Override
    public ProcessResult getDepartureDelay() throws Exception {
        ProcessResult rtnResult = new ProcessResult();
        HorizontalBarChartModel departureDelayModel = new HorizontalBarChartModel();
        departureDelayModel.setTitle("Departure Delay(+0.5hrs)");
        departureDelayModel.setSeriesColors("0000e6,ff3300");
        departureDelayModel.setShowPointLabels(true);
        departureDelayModel.setShowDatatip(false);
        departureDelayModel.setStacked(true);

        ChartSeries series = new ChartSeries();
        series.set("Test 1", 7);
        series.set("Test 2", 15);
        series.set("Test 3", 2);
        series.set("Test 4", 8);
        series.set("Test 5", 13);
        series.set("Test 6", 0);
        series.set("Test 7", 20);

        departureDelayModel.addSeries(series);

        rtnResult.setFlag(true);
        rtnResult.setObj(departureDelayModel);
        return rtnResult;
    }

    @Override
    public ProcessResult getTopMisReport() throws Exception {
        ProcessResult rtnResult = new ProcessResult();
        List<TopMisConnectDto> topMisList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            TopMisConnectDto dto = new TopMisConnectDto();
            dto.setColumn1("1123");
            dto.setColumn2("COT 08:30");
            dto.setColumn3("1234");
            dto.setColumn4("GTA 19:00");
            dto.setColumn5("01:16   30  40");
            topMisList.add(dto);
        }

        rtnResult.setFlag(true);
        rtnResult.setObj(topMisList);
        return rtnResult;
    }
}
