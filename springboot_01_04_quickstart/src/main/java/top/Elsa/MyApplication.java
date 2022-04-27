package top.Elsa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import top.Elsa.controller.BookController;
import top.Elsa.controller.User;

/**
 * @Author Elsa_zlt
 * @Date 2022/4/18--0:48
 * @Description
 */
@SpringBootApplication
public class MyApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(MyApplication.class);
        System.out.println("ctx.getBean(BookController.class) = " + ctx.getBean(BookController.class));
        System.out.println("ctx.getBean(User.class) = " + ctx.getBean(User.class));
    }
}
