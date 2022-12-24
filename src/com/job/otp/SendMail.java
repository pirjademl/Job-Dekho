package com.job.otp;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
//import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {
	
		public int sendotp(String Emailid,int otp) {
			Format f = new SimpleDateFormat("yyyy-MM-dd");
			String strDate = f. format(new Date());
			System. out. println("Current Date = "+strDate);
			Date date = new Date();
			String name ="Arun Yadav";
			String title ="Hello User  ";

			String message=String.format("<html>"
					+ "<body>"
					+ "<div style = \"font-size: 16px\">Dear <b>%s</b>,<br>"
					+ " We received your request for a single-use code to use with your JobDekho account <b></b> is confirmed.<br><br>"
					+ "Your One time code is <b></b>%s<br><br>"
					+ "Thank You!</b>.<br>"
					+ "From JOBDEKHO Team "
					+ "</div>"
					+ "</html>",
					Emailid, otp,otp);						
			String Subject="Your single-use code";
			String to =Emailid;
			String  from="iampirjade@gmail.com";
			Properties properties = System.getProperties();
			System.out.println(properties);
			properties.put("mail.smtp.host","smtp.gmail.com");	
			properties.put("mail.smtp.port","465");
			properties.put("mail.smtp.auth","true");
			properties.put("mail.smtp.socketFactory.port","465");
			properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
			Session session = Session.getInstance(properties, new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("iampirjade@gmail.com", "rmuhyoqfrobtpeed");
				}
			});
			try {
				MimeMessage m = new MimeMessage(session);
				m.setFrom(new InternetAddress(from));
				m.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
				m.setSubject(Subject);
				m.setContent(message, "text/html");
				Transport.send(m); 	
			} catch (MessagingException e) {
				e.printStackTrace();
				return 0;
			}
			return 1;
		}
	}