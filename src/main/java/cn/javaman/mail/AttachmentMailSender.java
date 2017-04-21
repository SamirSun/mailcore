package cn.javaman.mail;

import java.io.File;
import java.util.List;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.MimeMessageHelper;

/**
 * 带附件的邮件
 * @author sunxy
 */
public class AttachmentMailSender extends MailSender {

	@Override
	public void send(String[] to, String subject, String content, String[] cc, List<File> files) {

		try {
			MimeMessage message = sender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message,true,"UTF-8"); 
			if(files != null && files.size() > 0){
				for(File file:files){
					helper.addAttachment(file.getName(), file);
				}
			}
			if(cc != null && cc.length > 0){
	        	helper.setCc(cc);
	        }
	        helper.setFrom(FROM);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(content);
			sender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
