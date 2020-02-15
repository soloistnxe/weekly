package com.springboot.weekly.utils;

import java.util.Date;

public class DateUtils {
    public static Date getDate() {
        Date date = new Date();
        long longTime = date.getTime();  // 2019061017320511
        java.sql.Date sDate = new java.sql.Date(longTime);

        return sDate;
    }

}
