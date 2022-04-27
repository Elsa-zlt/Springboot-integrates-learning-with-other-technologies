package top.Elsa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.Elsa.service.MailService;

import javax.mail.MessagingException;

@SpringBootTest
class MailApplicationTests {
	@Autowired
	private MailService mailService;

	@Test
	void contextLoads() throws MessagingException {
		// mailService.sendMail();
		mailService.sendMailWithLinkAttachment();
	}

}
