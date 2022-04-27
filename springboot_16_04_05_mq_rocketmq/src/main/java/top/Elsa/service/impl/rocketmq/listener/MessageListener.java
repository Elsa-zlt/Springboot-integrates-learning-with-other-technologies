package top.Elsa.service.impl.rocketmq.listener;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @Author Elsa_zlt
 * @Date 2022/4/28--17:54
 * @Description
 */
@Component
@RocketMQMessageListener(topic = "order_id", consumerGroup = "group_rocketmq")
public class MessageListener implements RocketMQListener<String> {
    @Override
    public void onMessage(String orderId) {
        System.out.println("已完成短信发送业务(RocketMQ topic_queue)，id：" + orderId);
    }
}
