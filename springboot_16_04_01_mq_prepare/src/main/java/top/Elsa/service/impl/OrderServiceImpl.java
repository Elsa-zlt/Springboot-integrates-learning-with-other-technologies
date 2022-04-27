package top.Elsa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.Elsa.service.MessageService;
import top.Elsa.service.OrderService;

/**
 * @Author Elsa_zlt
 * @Date 2022/4/15--13:12
 * @Description
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private MessageService messageService;

    @Override
    public void order(String orderId) {
        // 一系列的操作，包含各种服务调用，处理各种业务
        System.out.println("订单开始处理");
        // 短信消息处理
        messageService.sendMessage(orderId);

        System.out.println("订单处理结束");
        System.out.println();
    }
}
