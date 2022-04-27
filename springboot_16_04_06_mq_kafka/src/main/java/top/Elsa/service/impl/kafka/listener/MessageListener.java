package top.Elsa.service.impl.kafka.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @Author Elsa_zlt
 * @Date 2022/4/28--21:05
 * @Description
 */
@Component
public class MessageListener {
    @KafkaListener(topics = "Elsa_zlt")
    public void onMessage(ConsumerRecord<String, String> record) {
        System.out.println("已完成短信发送业务(Kafka)，id：" + record.value());
    }
}
