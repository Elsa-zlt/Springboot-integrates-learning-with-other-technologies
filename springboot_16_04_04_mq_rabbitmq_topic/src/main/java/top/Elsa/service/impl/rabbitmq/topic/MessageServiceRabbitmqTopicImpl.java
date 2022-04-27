package top.Elsa.service.impl.rabbitmq.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.Elsa.service.MessageService;

/**
 * @Author Elsa_zlt
 * @Date 2022/4/15--18:57
 * @Description
 */
@Service
public class MessageServiceRabbitmqTopicImpl implements MessageService {
    @Autowired
    private AmqpTemplate amqpTemplate;
    @Override
    public void sendMessage(String orderId) {
        System.out.println("待发送短信的订单已纳入处理队列，id：" + orderId);
        // 指定routingKey的值为topic.order.id，消息会同时存到两个消息队列中
        amqpTemplate.convertAndSend("topicExchange", "topic.order.id", orderId);
    }

    @Override
    public String doMessage() {
        String orderId = (String) amqpTemplate.receiveAndConvert("topicExchange");
        System.out.println("已发送短信发送业务，id：" + orderId);
        return orderId;
    }
}
