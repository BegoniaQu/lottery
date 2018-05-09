package com.pub;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created by quyang on 2018/4/8.
 */
public class DateUtils {

    public static final String formalPattern = "yyyy-MM-dd HH:mm:ss";

    public static final String simplePattern = "yyyy-MM-dd";


    public static String date2String(Date date , String timeFormat){
        return new SimpleDateFormat(timeFormat).format(date);
    }

    public static int getYear(String date, String timeFormat){
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern(timeFormat));
        return localDate.getYear();
    }

    public static int getWeek(String date, String timeFormat){
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern(timeFormat));
        return localDate.getDayOfWeek().getValue();
    }

    public static String getWeekString(String date, String timeFormat){
        int dayOfWeek = getWeek(date, timeFormat);
        return intToWeek(dayOfWeek);
    }

    /**
     * xx年xx月xx日
     * @return
     */
    public static String getCurrentYmdString(){
        String  str = LocalDate.now().format(DateTimeFormatter.ofPattern(simplePattern));
        String []arr = str.split("-");
        return new StringBuilder().append(arr[0]).append("年").append(arr[1]).append("月").append(arr[2]).append("日").toString();
    }


    private static String intToWeek(int dayOfWeek){
        if(dayOfWeek == 1){
            return "星期一";
        }
        if(dayOfWeek == 2){
            return "星期二";
        }
        if(dayOfWeek == 3){
            return "星期三";
        }
        if(dayOfWeek == 4){
            return "星期四";
        }
        if(dayOfWeek == 5){
            return "星期五";
        }
        if(dayOfWeek == 6){
            return "星期六";
        }
        if(dayOfWeek == 7){
            return "星期日";
        }
        return "";
    }


    public static void main(String[] args) {
        System.out.println(DateUtils.getCurrentYmdString());
    }
}
