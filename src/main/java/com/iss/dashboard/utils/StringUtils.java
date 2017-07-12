package com.iss.dashboard.utils;

//import com.tmx.common.TMXAcceptorConstants;

public class StringUtils {

    public static String upperFirstChar(String string) {
        return string.substring(0,1).toUpperCase() + string.substring(1);
    }
    //TODO refactor this method is not Utility
    public static String doSetMethod(String string) {
        return "set"+upperFirstChar(string);
    }

    //TODO refactor this method is not Utility
    public static String doGetMethod(String string) {
        return "get"+upperFirstChar(string);
    }

    public static String upperFistUnderScoreChar(String string) {
        int index = string.indexOf("_");
        if(index == -1)
            return string;
        string = string.replaceAll("_", "");
        return string.substring(0,index)+string.substring(index,index+1).toUpperCase() + string.substring(index+1);
    }

    //TODO refactor this method is not Utility
    public static String prepareFieldForPOI(String fieldName){
        if(fieldName.equals("cpgmerchantId"))
            return  fieldName;
        String value = "";
        for (char c : fieldName.toCharArray()) {
            if(Character.isUpperCase(c))
                value+="_"+c;
            else
                value+=c;
        }
        return value.toLowerCase();
    }

    public static boolean isEmpty(String rcvData) {
        if (rcvData == null) {
            return true;

        } else if (rcvData.trim().length() == 0) {
            return true;

        } else {
            return false;
        }
    }

    public static boolean isInteger(String value){
        try {
            Integer.parseInt(value);
            return true;
        }catch (Exception ex){return false;}
    }
}
