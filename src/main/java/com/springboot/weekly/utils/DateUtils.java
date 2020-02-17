package com.springboot.weekly.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static String getDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        return dateString;
    }
    public static Date ConverToDate(String strDate) {
        DateFormat df = null;
        if(strDate.contains("HH")){
            df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }else{
            df = new SimpleDateFormat("yyyy-MM-dd");
        }

        try {
            return df.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static Date getFormatDate(){
        return ConverToDate(getDate());
    }

    public static void main(String[] args) {
        System.out.println(DateUtils.getFormatDate());
    }

}
