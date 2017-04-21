package cn.javaman.mailcore;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import cn.javaman.mail.AttachmentMailSender;
import cn.javaman.mail.HtmlMailSender;
import cn.javaman.mail.MailSender;
import cn.javaman.mail.TextMailSender;

@SuppressWarnings("serial")
public class MailSenderTest {
	String to = "sunxy1216@163.com";
	String[] toArray = new String[]{to};
	List<String> toList = new ArrayList<String>(){{add(to);}};
	List<File> files = new ArrayList<File>(){{add(new File("c:\\yy.png"));add(new File("c:\\sunxy.txt"));}};
	String[] cc = null;
	@Test
	public void textMailSenderTest(){
		MailSender ms = new TextMailSender();
		ms.send(to, "发送文本邮件", textContent);
	}
	@Test
	public void attachMailSenderTest(){
		MailSender ms = new AttachmentMailSender();
		ms.send(to, "发送附件邮件", attachmentContent, cc, files);
	}
	@Test
	public void htmlMailSenderTest(){
        MailSender ms = new HtmlMailSender();
        ms.send(to, "发送HTML邮件+附件", htmlContent, cc, files);
        ms.send(toArray, "发送HTML邮件+附件", htmlContent, toArray, null);
        ms.send(toList, "发送HTML邮件+附件", htmlContent, toList, files);
	}
	static final String htmlContent = "<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" /></head><body><center><H1 >HTML Test</H1></center><hr/>发送html邮件测试<br/>Welcome to access <a href=\"www.javaman.cn\">www.javaman.cn</a></body></html>";
	static final String textContent = "TextMailSender发送测试  www.javaman.cn";
	static final String attachmentContent = "AttachmentMailSender发送测试  www.javaman.cn";
	
}
