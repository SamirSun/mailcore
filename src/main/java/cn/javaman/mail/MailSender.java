package cn.javaman.mail;

import java.io.File;
import java.util.List;

import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * MIME 多用途因特网邮件扩展(Multipurpose Internet Mail Extensions) 
 * @author sunxy
 */
public abstract class MailSender extends MailCfg {
	JavaMailSenderImpl sender = getSender();
	private JavaMailSenderImpl getSender(){
		JavaMailSenderImpl jms = new JavaMailSenderImpl();
		jms.setHost(HOST);
		jms.setPort(PORT);
		jms.setUsername(USERNAME);
		jms.setPassword(PASSWORD);
		return jms;
	}
	public void send(String to,String subject,String content){
		send(to,subject,content,null);
	}
	
	public void send(String[] to,String subject,String content){
		send(to,subject,content,null,null);
	}
	public void send(String to,String subject,String content,String[] cc){
		send(to, subject, content,cc,null);
	}
	public void send(String to,String subject,String content,String[] cc,List<File> files){
		String[] to_array = new String[]{to};
		send(to_array, subject, content,cc,files);
	}
	public void send(List<String> to,String subject,String content,List<File> files){
		String[] to_array = to.toArray(new String[0]);
		send(to_array,subject,content,null,files);
	}
	public void send(List<String> to,String subject,String content,
			List<String> cc,List<File> files){
		String[] to_array = to.toArray(new String[0]);
		String[] cc_array = cc.toArray(new String[0]);
		send(to_array,subject,content,cc_array,files);
	}
	public abstract void send(String[] to,String subject,String content,
			String[] cc,List<File> files);
}
