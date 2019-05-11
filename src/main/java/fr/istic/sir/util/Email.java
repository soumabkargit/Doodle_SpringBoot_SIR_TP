/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.istic.sir.util;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;


/*
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;



import org.springframework.stereotype.Component;

/**
 *
 * @author soumabkar
 */
@Component
public class Email {
    
    
    //connexion internet nécéssaire
	
	
    
   
    @Autowired
	private JavaMailSender emailSender;
	
	private static String emailFrom="projetsoumabkar@gmail.com"; //adresse email envoyant le message (doit être nécéssairement une adresse gmail)
	private static String passwordEmailSender="ProjetSoum@bk@r12011991@"; //mot de passe de l'adresse gmail envoyant le message
	private Properties props;
	private Session session;
        
        
        public Email()
	{
		props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(emailFrom, passwordEmailSender);
			}
		  });
	}

        
        
	public void sendSimpleMessage(String to, String subject, String text) {
		SimpleMailMessage message = new SimpleMailMessage(); 
		
		message.setFrom(emailFrom);
		message.setTo(to); 
        message.setSubject(subject); 
        message.setText(text);
        emailSender.send(message);  
	}
	
	public void sendMessageWithAttachment(String to, String subject, String text, List<File> fileToAttachments) throws MessagingException {
	    
	    MimeMessage message = emailSender.createMimeMessage();   
	    MimeMessageHelper helper = new MimeMessageHelper(message, true);
	    
	    helper.setFrom(emailFrom);
	    helper.setTo(to);
	    helper.setSubject(subject);
	    helper.setText(text);
	    
	    Iterator<File> iterator = fileToAttachments.iterator();
	    while(iterator.hasNext()) {
	    	File file = iterator.next();
	    	FileSystemResource fileSystemResource = new FileSystemResource(file);
	    	helper.addAttachment(file.getName(), fileSystemResource);
	    }
	    
	    emailSender.send(message);
	}

    
}
