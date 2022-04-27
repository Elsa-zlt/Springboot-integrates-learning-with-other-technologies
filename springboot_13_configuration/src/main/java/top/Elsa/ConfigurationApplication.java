package top.Elsa;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import top.Elsa.config.ServerConfig;

@SpringBootApplication
// 统一配置要管理的类，让配置不乱
// 在这个注解里面指定了对应类，就不用在具体配置类上面加@Component注解了，会导致冲突
@EnableConfigurationProperties(ServerConfig.class)
public class ConfigurationApplication {
    @Bean
    @ConfigurationProperties(prefix = "datasource")
    public DruidDataSource dataSource() {
        DruidDataSource ds = new DruidDataSource();
        //ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        return ds;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(ConfigurationApplication.class, args);
        System.out.println("ctx.getBean(ServerConfig.class) = " + ctx.getBean(ServerConfig.class));
        DruidDataSource ds = ctx.getBean(DruidDataSource.class);
        // System.out.println("ds = " + ds);
        System.out.println("ds.getDriverClassName() = " + ds.getDriverClassName());
    }

}
