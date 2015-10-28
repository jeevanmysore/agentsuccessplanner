package com.agentplannertool.backend.emailutil;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;



public class EmailUtil {
	
	private static Logger log=Logger.getLogger(EmailUtil.class);
	private static String host;
	private static String protocol;
	private static String port;
	private static String auth;
	private static String starttls;
	private static String socketFactoryPort;
	private static String socketFactoryClass;
	private static String socketFactoryFallback;
	private static String usrname;
	private static String pasword;
	
	public static String getHost() {
		return host;
	}
	public static void setHost(String host) {
		EmailUtil.host = host;
	}
	public static String getProtocol() {
		return protocol;
	}
	public static void setProtocol(String protocol) {
		EmailUtil.protocol = protocol;
	}
	public static String getPort() {
		return port;
	}
	public static void setPort(String port) {
		EmailUtil.port = port;
	}
	public static String isAuth() {
		return auth;
	}
	public static void setAuth(String auth) {
		EmailUtil.auth = auth;
	}
	public static String isStarttls() {
		return starttls;
	}
	public static void setStarttls(String starttls) {
		EmailUtil.starttls = starttls;
	}
	public static String getSocketFactoryPort() {
		return socketFactoryPort;
	}
	public static void setSocketFactoryPort(String socketFactoryPort) {
		EmailUtil.socketFactoryPort = socketFactoryPort;
	}
	public static String getSocketFactoryClass() {
		return socketFactoryClass;
	}
	public static void setSocketFactoryClass(String socketFactoryClass) {
		EmailUtil.socketFactoryClass = socketFactoryClass;
	}
	public static String isSocketFactoryFallback() {
		return socketFactoryFallback;
	}
	public static void setSocketFactoryFallback(String socketFactoryFallback) {
		EmailUtil.socketFactoryFallback = socketFactoryFallback;
	}
	public static String getUsername() {
		return usrname;
	}
	public static void setUsername(String usrname) {
		EmailUtil.usrname = usrname;
	}
	public static String getPassword() {
		return pasword;
	}
	public static void setPassword(String pasword) {
		EmailUtil.pasword = pasword;
	}
	
	public void sendMail(String from,String to,String subject,String Body)
	{
		Properties props = new Properties();
	     //String host="smtp.gmail.com";
		
	     props.put("mail.transport.protocol", protocol);
	     props.put("mail.smtp.host", host);
	     props.put("mail.smtp.port", port);
	     props.put("mail.smtp.auth", auth);
	     props.put("mail.smtp.starttls.enable",starttls);
	     props.put("mail.smtp.socketFactory.port",socketFactoryPort);
	     props.put("mail.smtp.socketFactory.class",socketFactoryClass);
	     props.put("mail.smtp.socketFactory.fallback",socketFactoryFallback);
	     
	     
	     
	    
         Session session = Session.getDefaultInstance(props,new javax.mail.Authenticator() {
             protected PasswordAuthentication getPasswordAuthentication() {
                 return new PasswordAuthentication(
                		 usrname,pasword);// Specify the Username and the PassWord
             }
         });
	    	    
	    MimeMessage message = new MimeMessage( session );
	    try {
	       	InternetAddress addressFrom = new InternetAddress(from);
		      message.setFrom(addressFrom);
	      message.addRecipient(
	        Message.RecipientType.TO, new InternetAddress(to)
	      );
	      message.setSubject( subject );
	      message.setText( Body );
	      Transport.send( message );
	    }catch (MessagingException ex){
		      System.err.println("Cannot send email. " + ex);
	
	    }
	    }
}