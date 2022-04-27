package top.Elsa.service.impl.activemq.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * @Author Elsa_zlt
 * @Date 2022/4/15--17:07
 * @Description
 */
@Component
public class MessageListener {
    @JmsListener(destination = "order.queue.id")
    // 还可以将当前方法的返回值再发送到其他队列
    @SendTo("order.other.queue.id")
    public String receive(String orderId) {
        System.out.println("已完成短信发送业务，id：" + orderId);
        return "done::id::" + orderId;
    }
}
