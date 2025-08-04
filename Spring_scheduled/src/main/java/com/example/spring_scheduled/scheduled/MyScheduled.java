package com.example.spring_scheduled.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MyScheduled {

    // @Scheduled:用於設置定時任務
    // cron屬性:cron表達式(字符串格式)
    // (秒_0-59, 分_0-59, 時_0-23, 日_1-31, 月_1-12, 星期_1-7, 年(可選 通常不寫)_1970-2099 )
    // 每隔3秒執行一次
    @Scheduled(cron="0/3 * * * * ?")
    public void test1(){
        System.out.println("執行任務： " + new Date());
    }
}
