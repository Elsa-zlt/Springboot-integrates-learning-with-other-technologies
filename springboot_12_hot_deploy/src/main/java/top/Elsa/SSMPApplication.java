package top.Elsa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SSMPApplication {

    public static void main(String[] args) {
        // 这里设置关闭热部署，优先级比配置文件高，防止配置文件多的时候找不到对应的热部署配置
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(SSMPApplication.class, args);
    }

}
