package com.zhangshuaibiao.demo.task.schedule;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Future;

/**
 * @author zhangsb29016
 * @copyright 恒生电子股份有限公司 版权所有<br>
 * @create 2020/7/20 17:53
 * @desc
 */
@Component
@Configurable
@EnableScheduling
public class ConcurrentTasks {
    @Async("taskExecutor")
    @Scheduled(fixedRate = 1000 *3)
    public void reportCurrentTime(){

        System.out.println ("线程" + Thread.currentThread().getName() + "开始执行定时任务===&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&7&&&====》"
                + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        long start = System.currentTimeMillis();
        Future<Boolean> isOk1;
        Future<Boolean> isOk2;

    }
}
