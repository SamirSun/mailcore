package cn.javaman.mail;

import java.io.File;
import java.util.List;
import org.springframework.mail.SimpleMailMessage;

/**
 * 简单文本邮件
 * @author sunxy
 */
public class TextMailSender extends MailSender  {
	
	@Override
	public void send(String[] to, String subject, String content, String[] cc, List<File> files) {
		SimpleMailMessage mail = new SimpleMailMessage(); 
		mail.setFrom(FROM);
		mail.setSubject(subject);
		mail.setText(content);
		mail.setTo(to);
		if(cc != null && cc.length > 0){
			mail.setCc(cc);
        }
		sender.send(mail);
	}

}
