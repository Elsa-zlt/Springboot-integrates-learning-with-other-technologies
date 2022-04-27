package top.Elsa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Elsa_zlt
 * @Date 2022/4/23--23:00
 * @Description
 */
@Configuration
public class MsgConfig {
    @Bean
    public String msg() {
        return "bean msg";
    }
}
