package org.virtue.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {

    @Scheduled(cron = "5 0 0 * * ?")
    public void scheduledTask1(){
        System.out.println("定时任务1");
    }


    @Scheduled(initialDelay =  1000 * 10,fixedDelay = 1000 * 5)
    public void scheduledTask2(){
        System.out.println("任务2执行时间："+System.currentTimeMillis());
        System.out.println("定时任务2");
        try {
            Thread.sleep(2*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("任务2结束时间："+System.currentTimeMillis());
    }

//    @Scheduled(initialDelay =  1000 * 10,fixedRate = 1000 * 5)
//    public void scheduledTask3(){
//        System.out.println("任务3执行时间："+System.currentTimeMillis());
//        System.out.println("定时任务3");
//        try {
//            Thread.sleep(2*1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("任务3结束时间："+System.currentTimeMillis());
//    }
}
