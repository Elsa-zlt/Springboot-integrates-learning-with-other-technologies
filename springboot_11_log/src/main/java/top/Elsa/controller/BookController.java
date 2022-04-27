package top.Elsa.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    // 创建记录日志的对象
    private static Logger log = LoggerFactory.getLogger(BookController.class);

    @GetMapping
    public String getById() {
        System.out.println("springboot is running...");
        log.trace("log trace");
        log.debug("log debug ...");
        log.info("log info ...");
        log.warn("log warn ...");
        log.error("log error ...");
        return "springboot is running...";
    }
}
