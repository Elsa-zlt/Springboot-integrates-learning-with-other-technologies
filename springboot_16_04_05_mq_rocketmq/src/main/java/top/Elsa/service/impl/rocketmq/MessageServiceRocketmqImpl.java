package top.Elsa.service.impl.rocketmq;

import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.Elsa.service.MessageService;

/**
 * @Author Elsa_zlt
 * @Date 2022/4/28--14:04
 * @Description
 */
@Service
public class MessageServiceRocketmqImpl implements MessageService {
    @Autowired
    private RocketMQTemplate rocketMQTemplate;
    @Override
    public void sendMessage(String orderId) {
        System.out.println("待发送短信的订单已纳入处理队列，id：" + orderId);
        // 注意RocketMQ不支持类似order.queue.id这样的带特殊字符的destination
        // 发送同步消息，基本不用
        // rocketMQTemplate.convertAndSend("order_id", orderId);
        // 发送异步消息
        SendCallback callback = new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                System.out.println("消息发送成功！");
            }

            @Override
            public void onException(Throwable throwable) {
                System.out.println("消息发送失败！");
            }
        };
        rocketMQTemplate.asyncSend("order_id", orderId, callback);
    }

    @Override
    public String doMessage() {
        return null;
    }
}
