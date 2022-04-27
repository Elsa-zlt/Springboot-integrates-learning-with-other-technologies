package top.Elsa.service.impl;

import org.springframework.stereotype.Service;
import top.Elsa.service.MessageService;

import java.util.ArrayList;

/**
 * @Author Elsa_zlt
 * @Date 2022/4/15--13:15
 * @Description
 */
@Service
public class MessageServiceImpl implements MessageService {
    private ArrayList<String> msgList = new ArrayList<String>();
    @Override
    public void sendMessage(String orderId) {
        System.out.println("待发送短信的订单已纳入处理队列，id：" + orderId);
        msgList.add(orderId);
    }

    @Override
    public String doMessage() {
        if (msgList.size() > 0) {

            String orderId = msgList.remove(0);
            System.out.println("已发送短信发送业务，id：" + orderId);
            return orderId;
        }
        return "消息队列为空，没有消息待处理";
    }
}
