package com.jk.controller;

import com.jk.pojo.NewsFlash;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeTest {

  /*    public String Time(String time, NewsFlash newsFlash){
 		long nowTime=System.currentTimeMillis();  //获取当前时间的毫秒数
          String msg = null;

          SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          Date setTime =newsFlash.setCreattime(  newsFlash.setCreattime(sdf.format(date1)););      //指定时间

          try {
              setTime = sdf.parse(time);  //将字符串转换为指定的时间格式
          } catch (ParseException e) {
              e.printStackTrace();
          }

          long reset=setTime.getTime();   //获取指定时间的毫秒数
          long dateDiff=nowTime-reset;

          if(dateDiff<0){
              msg="输入的时间不对";
          }else{
              long dateTemp1=dateDiff/1000; //秒
          long dateTemp2=dateTemp1/60; //分钟
          long dateTemp3=dateTemp2/60; //小时
          long dateTemp4=dateTemp3/24; //天数
          long dateTemp5=dateTemp4/30; //月数
          long dateTemp6=dateTemp5/12; //年数
          if(dateTemp6>0){
              msg = dateTemp6+"年前";

          }else if(dateTemp5>0){
              msg = dateTemp5+"个月前";

          }else if(dateTemp4>0){
              msg = dateTemp4+"天前";

          }else if(dateTemp3>0){
              msg = dateTemp3+"小时前";

          }else if(dateTemp2>0){
              msg = dateTemp2+"分钟前";

          }else if(dateTemp1>0){
              msg = "刚刚";

          }
      }
		return msg;

}
*/






    public static String getStringDate(Date date)
    {
        String strTemp = "";
        long timestampThat = date.getTime();//时间戳---  timestamp当前时间变量

        Date now = new Date();
        long timestampNow = now.getTime();  //当前系统时间 时间戳

        long diffSec = (timestampNow - timestampThat)/1000;//相差 秒数

        System.out.println(diffSec);
        if(diffSec < 60)
        {
            strTemp = "刚刚";
        }
        else
        {
            long diffMin = diffSec / 60;
            if(diffMin < 60)
            {
                strTemp = diffMin + "分钟前";
            }
            else //大于60分钟（1小时）
            {
                long diffHour = diffMin / 60;
                if(diffHour < 24)
                {
                    strTemp = diffHour + "小时前";
                }
                else//大于1天
                {
                    long diffDay = diffHour / 24;
                    if(diffDay < 7)
                    {
                        strTemp = diffDay + "天前";
                    }

                }
            }
        }


        return strTemp;
    }


}
