package cn.javaman.mail;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * 获取mail.properties中配置信息
 * @author: sunxy
 */
public class MailCfg {
	private static Properties properties = new Properties();
	static {
		try {
			String configFileName = "mail.properties";
			java.net.URL fileURL = Thread.currentThread()
					.getContextClassLoader().getResource(configFileName);

			File configFile = null;
			if (fileURL == null) {
				System.out.println(configFileName + " not found in the classpath");
			} else {
				configFile = new File(fileURL.toURI());
			}
			properties.load(new BufferedInputStream(new FileInputStream(configFile)));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static final String FROM = properties.getProperty("mail.from");
	public static final String HOST = properties.getProperty("mail.host");
	public static final int PORT = Integer.parseInt(properties.getProperty("mail.port","25"));
	public static final String USERNAME = properties.getProperty("mail.username");
	public static final String PASSWORD = properties.getProperty("mail.password");
	public static final String CHARSET = properties.getProperty("mail.charset");
}
