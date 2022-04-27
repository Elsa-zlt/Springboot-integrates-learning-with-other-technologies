package top.Elsa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Elsa_zlt
 * @Date 2022/4/17--19:14
 * @Description
 */
@RestController
@RequestMapping("/books")
public class BookController {
    // 读取yaml数据中的单一数据
    @Value("${country}")
    private String country1;

    @Value("${user.name}")
    private String name1;

    @Value("${user2.name}")
    private String name2;

    @Value("${habits[1]}")
    private String habit;

    @Value("${users[1].age}")
    private Integer age;

    @Value("${tempDir}")
    private String tempDir;

    @Value("${tempDir1}")
    private String tempDir1;

    // 使用自动装配将所有的数据封装到Environment对象中
    @Autowired
    private Environment env;

    @Autowired
    private MyDataSource dataSource;

    @GetMapping
    public String getById() {
        System.out.println("springboot is running...");
        System.out.println("country1 = " + country1);
        System.out.println("name1 = " + name1);
        System.out.println("name2 = " + name2);
        System.out.println("habit = " + habit);
        System.out.println("age = " + age);
        System.out.println("tempDir = " + tempDir);
        System.out.println("tempDir1 = " + tempDir1);
        System.out.println("====================================");
        System.out.println(env.getProperty("server.port"));
        System.out.println("country1 = " + env.getProperty("country"));
        System.out.println("name1 = " + env.getProperty("user.name"));
        System.out.println("name2 = " + env.getProperty("user2.name"));
        System.out.println("habit = " + env.getProperty("habits[1]"));
        System.out.println("age = " + env.getProperty("users[1].age"));
        System.out.println("tempDir = " + env.getProperty("tempDir"));
        System.out.println("tempDir1 = " + env.getProperty("tempDir1"));
        System.out.println("=====================================");
        System.out.println("dataSource = " + dataSource);
        return "springboot is running...";
    }
}
