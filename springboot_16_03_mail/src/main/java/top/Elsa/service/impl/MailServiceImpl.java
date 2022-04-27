package top.Elsa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import top.Elsa.service.MailService;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @Author Elsa_zlt
 * @Date 2022/4/15--2:10
 * @Description
 */
@Service
public class MailServiceImpl implements MailService {
    @Autowired
    private JavaMailSender javaMailSender;

    // 发送人
    private String from = "xxxxxxxx@qq.com";

    // 接收人
    private String to = "xxxxxxxxx@163.com";



    @Override
    public void sendMail() {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(from + "(钟良堂)");
        msg.setTo(to);
        // 主题
        String subject = "测试发邮件";
        // 正文
        String context = "测试邮件的正文内容";
        msg.setSubject(subject);
        msg.setText(context);
        javaMailSender.send(msg);
    }

    @Override
    // 发送带链接和附件的消息
    public void sendMailWithLinkAttachment() throws MessagingException {
        MimeMessage msg = javaMailSender.createMimeMessage();
        // 要想发送附件，需要指定第二个参数为true
        MimeMessageHelper msgHelper = new MimeMessageHelper(msg, true);
        msgHelper.setFrom(from + "(钟良堂)");
        msgHelper.setTo(to);
        // 主题
        String subject = "测试发送带链接和附件的消息";
        // 正文
        String context = "<a href='https://www.baidu.com'>百度一下</a><br><img src='https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg01.vgtime.com%2Fgame%2Fcover%2F2021%2F06%2F09%2F210609232854124_u93176.jpg&refer=http%3A%2F%2Fimg01.vgtime.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1647456598&t=8808f4643e61d9d2790f9f83d9f620a5'>";
        msgHelper.setSubject(subject);
        // 要想正文以html格式解析，需要指定第二个参数为true
        msgHelper.setText(context, true);

        // 添加附件
        File file1 = new File("D:\\ideacode\\spring-boot-study\\springboot_16_03_mail\\src\\main\\resources\\test.jpg");
        File file2 = new File("D:\\ideacode\\spring-boot-study\\springboot_16_03_mail\\target\\springboot_16_03_mail-0.0.1-SNAPSHOT.jar");
        msgHelper.addAttachment(file1.getName(), file1);
        msgHelper.addAttachment(file2.getName(), file2);

        javaMailSender.send(msg);
    }
}
