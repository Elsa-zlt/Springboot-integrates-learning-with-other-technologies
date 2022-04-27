package top.Elsa.service.impl.rabbitmq.topic.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @Author Elsa_zlt
 * @Date 2022/4/15--19:03
 * @Description
 */
@Configuration
public class RabbitTopicConfig {
    @Bean
    // Topic模式的队列
    public Queue topicQueue1() {
        // durable:是否持久化，默认false
        // exclusive:是否当前连接专用，默认False，连接关闭后队列即被删除
        // autoDelete:是否自动删除，当生产者或消费者不再使用此队列，自动删除
        // 一个参数的构造方法内部默认调用了4个参数的构造方法，后三个参数依次为true,false,false
        return new Queue("topic_queue1");
    }

    @Bean
    // Topic模式的队列
    public Queue topicQueue2() {
        // durable:是否持久化，默认false
        // exclusive:是否当前连接专用，默认False，连接关闭后队列即被删除
        // autoDelete:是否自动删除，当生产者或消费者不再使用此队列，自动删除
        // 一个参数的构造方法内部默认调用了4个参数的构造方法，后三个参数依次为true,false,false
        return new Queue("topic_queue2");
    }

    @Bean
    // Topic模式的交换机
    public TopicExchange topicExchange() {
        return new TopicExchange("topicExchange");
    }

    @Bean
    public Binding bindingTopic1() {
        return BindingBuilder.bind(topicQueue1()).to(topicExchange()).with("topic.*.id");
    }

    @Bean
    public Binding bindingTopic2() {
        return BindingBuilder.bind(topicQueue2()).to(topicExchange()).with("topic.order.*");
    }
}
