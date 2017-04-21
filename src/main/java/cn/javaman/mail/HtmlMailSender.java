package cn.javaman.mail;

import java.io.File;
import java.util.List;
import javax.mail.internet.MimeMessage;
import org.springframework.mail.javamail.MimeMessageHelper;

/**
 * HTML格式邮件,可选附件
 * @author: sunxy
 **/
public class HtmlMailSender extends MailSender {

	@Override
	public void send(String[] to, String subject, String content, String[] cc, List<File> files) {
		try {
			MimeMessage message = sender.createMimeMessage();
	        MimeMessageHelper helper ;
	        if(files != null && files.size() > 0){
	        	helper = new MimeMessageHelper(message,true,"UTF-8");
	        	for(File file:files){
					helper.addAttachment(file.getName(), file);
				}
	        }else{
	        	helper = new MimeMessageHelper(message,"UTF-8");
	        }
	        if(cc != null && cc.length > 0){
	        	helper.setCc(cc);
	        }
			helper.setFrom(FROM);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(content,true);
	        sender.send(message);
		} catch(Exception e){
			e.printStackTrace();
		}
	}

}
