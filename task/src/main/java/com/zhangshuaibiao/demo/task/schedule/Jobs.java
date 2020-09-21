package com.zhangshuaibiao.demo.task.schedule;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author zhangsb29016
 * @copyright 恒生电子股份有限公司 版权所有<br>
 * @create 2020/7/20 15:17
 * @desc
 */
@Component
//@EnableScheduling //开启定时任务
public class Jobs {
    //表示每隔5秒
    //@Scheduled(fixedDelay = 500)
    public void fixedDelayJob(){
        System.out.println("fixedDeply 每隔5秒"+new Date());
    }

    //表示每隔3秒
   // @Scheduled(fixedDelay = 3000)
    public void fixedRateJob(){
        System.out.println("fixedRate 每个3秒"+new Date());
    }

    //表示每天8时30分0秒执行
   // @Scheduled(cron = "0 0,52 0,15 ? * ? ")
    public void cronJob(){
        System.out.println(new Date()+"..>>cron....");
    }
}
