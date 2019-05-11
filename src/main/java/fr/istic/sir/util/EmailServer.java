/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.istic.sir.util;

/**
 *
 * @author soumabkar
 */
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


public class EmailServer {
	//connexion internet nécéssaire
	private static String emailSender="projetsoumabkar@gmail.com"; //adresse email envoyant le message (doit être nécéssairement une adresse gmail)
	private static String passwordEmailSender="ProjetSoum@bk@r12011991@"; //mot de passe de l'adresse gmail envoyant le message
	private Properties props;
	private Session session;

	public EmailServer()
	{
		props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(emailSender, passwordEmailSender);
			}
		  });
	}
	
	
	public Boolean sendEmail(String toAdress,String subject,String content){
		try {
			Message msg = new MimeMessage(session);
			try {
				msg.setFrom(new InternetAddress(emailSender," CNPS SDMAM "+emailSender));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			msg.setRecipients(Message.RecipientType.TO,InternetAddress.parse(toAdress));
			msg.setSubject(subject);
                    //     MimeBodyPart messageBodyPart = new MimeBodyPart();
                        Multipart multipart = new MimeMultipart(); 
          //              multipart.addBodyPart(htmlBodyPart); //1
                        
                        msg.setContent(multipart);//1
                        
			Transport.send(msg);//1
                       
            System.out.println("L'Email a bien été envoyé au destinataire ");//1
			return true;
                } catch (MessagingException e) {
			e.printStackTrace();
			return false;
			
		}
		
	}

	

}