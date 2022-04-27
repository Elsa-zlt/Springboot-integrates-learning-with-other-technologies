package top.Elsa.controller;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author Elsa_zlt
 * @Date 2022/4/19--22:09
 * @Description
 */
// 1、定义数据模型封装yaml文件中对应的数据
// 2、定义为spring管控的Bean
// 3、指定加载的数据
@ConfigurationProperties(prefix = "datasource")
@Component
@Data
public class MyDataSource {
    private String driver;
    private String url;
    private String username;
    private String password;
}
