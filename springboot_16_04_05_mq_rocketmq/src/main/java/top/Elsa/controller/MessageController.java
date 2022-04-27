package top.Elsa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.Elsa.service.MessageService;

/**
 * @Author Elsa_zlt
 * @Date 2022/4/15--13:33
 * @Description
 */
@RestController
@RequestMapping("/msgs")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @GetMapping
    public String doMessage() {
        String id = messageService.doMessage();
        return id;
    }
}
