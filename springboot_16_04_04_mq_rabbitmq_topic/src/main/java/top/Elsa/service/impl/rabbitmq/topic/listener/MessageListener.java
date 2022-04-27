package top.Elsa.service.impl.rabbitmq.topic.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author Elsa_zlt
 * @Date 2022/4/15--19:46
 * @Description
 */
@Component
public class MessageListener {
    @RabbitListener(queues = "topic_queue1")
    public void receive1(String orderId) {
        System.out.println("已完成短信发送业务(RabbitMQ topic_queue111111)，id：" + orderId);
    }

    @RabbitListener(queues = "topic_queue2")
    public void receive2(String orderId) {
        System.out.println("已完成短信发送业务(RabbitMQ topic_queue222222)，id：" + orderId);
    }
}
