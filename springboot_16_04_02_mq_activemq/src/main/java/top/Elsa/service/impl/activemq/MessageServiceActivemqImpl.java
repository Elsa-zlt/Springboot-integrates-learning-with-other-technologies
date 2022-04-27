package top.Elsa.service.impl.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;
import top.Elsa.service.MessageService;

/**
 * @Author Elsa_zlt
 * @Date 2022/4/15--16:15
 * @Description
 */
@Service
public class MessageServiceActivemqImpl implements MessageService {
    @Autowired
    private JmsMessagingTemplate messagingTemplate;

    @Override
    public void sendMessage(String orderId) {
        System.out.println("待发送短信的订单已纳入处理队列，id：" + orderId);
        // 将消息存到消息队列的时候如果不指定destination，也就是队列名，就会存到默认的队列中， 如果application.yml中没有配置默认的队列名， 就会报错
        // messagingTemplate.convertAndSend(orderId);
        // 也可以手动指定队列名
        messagingTemplate.convertAndSend("order.queue.id", orderId);
    }

    @Override
    public String doMessage() {
        // 从默认队列中获取消息
        // String orderId = messagingTemplate.receiveAndConvert(String.class);
        // 从指定队列中获取消息
        String orderId = messagingTemplate.receiveAndConvert("order.queue.id", String.class);
        System.out.println("已发送短信发送业务，id：" + orderId);
        return orderId;
    }
}
