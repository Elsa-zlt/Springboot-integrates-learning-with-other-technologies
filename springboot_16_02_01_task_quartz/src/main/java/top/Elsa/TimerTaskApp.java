package top.Elsa;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @Author Elsa_zlt
 * @Date 2022/4/14--23:52
 * @Description
 */
public class TimerTaskApp {
    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Timer task run...");
            }
        };
        timer.schedule(task, 0, 2000);
    }
}
