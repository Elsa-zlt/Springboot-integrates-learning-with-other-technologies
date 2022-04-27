package top.Elsa;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Author Elsa_zlt
 * @Date 2022/4/15--0:49
 * @Description
 */
@Component
public class MyTask {
    @Scheduled(cron = "0/3 * * * * ?")
    public void print() {
        System.out.println(Thread.currentThread().getName() + ": spring task run...");
    }
}
