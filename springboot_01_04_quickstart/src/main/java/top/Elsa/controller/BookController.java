package top.Elsa.controller;

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
    @GetMapping
    public String getById() {
        System.out.println("springboot is running...4");
        return "springboot is running...4";
    }
}
