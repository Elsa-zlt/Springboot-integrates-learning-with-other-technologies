package top.Elsa.service;

import javax.mail.MessagingException;

/**
 * @Author Elsa_zlt
 * @Date 2022/4/15--2:10
 * @Description
 */
public interface MailService {
    // 发送简单消息
    void sendMail();

    // 发送带链接和附件的消息
    void sendMailWithLinkAttachment() throws MessagingException;
}
