package top.Elsa.service.impl.rabbitmq.direct.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author Elsa_zlt
 * @Date 2022/4/15--19:46
 * @Description
 */
@Component
public class MessageListener {
    @RabbitListener(queues = "direct_queue")
    public void receive(String orderId) {
        System.out.println("已完成短信发送业务(RabbitMQ Direct one)，id：" + orderId);
    }
}
