package top.Elsa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.Elsa.service.OrderService;

/**
 * @Author Elsa_zlt
 * @Date 2022/4/15--13:20
 * @Description
 */
@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("{orderId}")
    public void order(@PathVariable String orderId) {
        orderService.order(orderId);
    }
}
