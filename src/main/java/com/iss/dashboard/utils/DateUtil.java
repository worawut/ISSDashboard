package com.iss.dashboard.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtil {

    public static final String DATE_YYYY_MM_DD_HHMMSS = "YYYY-MM-DD HH:MM:SS";
    public static final String DATE_DASH_DDMMYY_HHMMSS = "dd-MM-yyyy HH:mm:ss";
    public static final String DATE_DASHBOARD_FORMAT = "dd-MMM-yyyy HH:mm";
    public static final String DATE_YYYYMMDD ="yyyyMMdd";
    public static final String DATE_MM_DD_YYYY ="MM/dd/yyyy";
    public static final String DATE_DD_MM_YYYY ="dd/MM/yyyy";
    public static final String DATE_YYYY_MM_DD_HH_MM_SS ="yyyy-MM-dd-HH.mm.ss";
    public static final String DATE_DDMMYYYY ="ddMMyyyy";
    public static final String TIME_HH_MM ="HH.mm";
    public static final String TIME_HH_MM_SS ="hhmmss";
    private static final Logger log = LoggerFactory.getLogger(DateUtil.class);

    public static final String DATE_DDMMYYYYHHMMSS ="ddMMyyyyhhmmss";
    public static String dateToStringWithFormat(Date date, String format) {
        return new SimpleDateFormat(format).format(date);
    }

    public static Date getToDateAfterDays(Date currentDate,Integer day){
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        cal.add(Calendar.DATE, day);
        return cal.getTime();
    }

    public static Date getCurrentDate(){
        return Calendar.getInstance().getTime();
    }

    public static Date stringToDate(String dateString, String format){
        Date date = null;
        try{
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
            date =  (null != dateString) ? simpleDateFormat.parse(dateString) : null;
        }catch (ParseException e){
            log.error("Error to parsing date. {}", dateString);
        }
        return date;
    }

  public static Date stringyyyyMMddToDate(String dateString) {
    Date date = null;
    try {
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_YYYYMMDD);
        date = (null != dateString) ? simpleDateFormat.parse(dateString) : null;
    }catch (ParseException e){
      log.error("Error to parsing date. {}", dateString);
    }
    return date;
  }


    public static String convertDateToStringYYYYMMDD(Date inDate) {
        SimpleDateFormat format = new SimpleDateFormat(DATE_YYYYMMDD, Locale.ENGLISH);
        return format.format(inDate);
    }

    public static String convertDateToString_MM_DD_YYYY(Date inDate) {
        SimpleDateFormat format = new SimpleDateFormat(DATE_MM_DD_YYYY, Locale.ENGLISH);
        return format.format(inDate);
    }

    public static String convertDateToString_DD_MM_YYYY(Date inDate) {
        SimpleDateFormat format = new SimpleDateFormat(DATE_DD_MM_YYYY, Locale.ENGLISH);
        return format.format(inDate);
    }

    public static String convertDateToString(Date inDate,String formatDate) {
        SimpleDateFormat format = new SimpleDateFormat(formatDate, Locale.ENGLISH);
        return format.format(inDate);
    }

    public static String convertDateToString_DDMMYYYY(Date inDate) {
        SimpleDateFormat format = new SimpleDateFormat(DATE_DDMMYYYY, Locale.ENGLISH);
        return format.format(inDate);
    }

    public static String convertDateToString_YYYY_MM_DD_HH_MM_SS(Date inDate) {
        SimpleDateFormat format = new SimpleDateFormat(DATE_YYYY_MM_DD_HH_MM_SS, Locale.ENGLISH);
        return format.format(inDate);
    }

    public static String convertDateToTimeHHMM(Date inDate) {
        SimpleDateFormat format = new SimpleDateFormat(TIME_HH_MM, Locale.ENGLISH);
        return format.format(inDate);
    }

    public static String convertDateToTimeHHMMSS(Date inDate){
        SimpleDateFormat format = new SimpleDateFormat(TIME_HH_MM_SS, Locale.ENGLISH);
        return format.format(inDate);
    }

    public static String convertDateToDATE_DDMMYYYYHHMMSS(Date inDate) {
        SimpleDateFormat format = new SimpleDateFormat(DATE_DDMMYYYYHHMMSS, Locale.ENGLISH);
        return format.format(inDate);
    }

    public static void main(String arg[]){

    }
}
