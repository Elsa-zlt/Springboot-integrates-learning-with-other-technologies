package top.Elsa.service.impl.rabbitmq.direct;

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
public class MessageServiceRabbitmqDirectImpl implements MessageService {
    @Autowired
    private AmqpTemplate amqpTemplate;
    @Override
    public void sendMessage(String orderId) {
        System.out.println("待发送短信的订单已纳入处理队列，id：" + orderId);
        // 指定RabbitDirectConfig中的内容
        amqpTemplate.convertAndSend("directExchange", "direct", orderId);
    }

    @Override
    public String doMessage() {
        String orderId = (String) amqpTemplate.receiveAndConvert("directExchange");
        System.out.println("已发送短信发送业务，id：" + orderId);
        return orderId;
    }
}
