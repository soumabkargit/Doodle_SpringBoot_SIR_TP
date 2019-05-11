package fr.istic.sir.util;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Properties;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author soumabkar
 */
public class EnvoyerMail {
    
    //connexion internet nécéssaire
	private static final String expidideur="projetsoumabkar@gmail.com"; //adresse email envoyant le message (doit être nécéssairement une adresse gmail)
	private static final String motPasse="ProjetSoum@bk@r12011991@"; //mot de passe de l'adresse gmail envoyant le message
	private Properties props;
	private final Session session;

	public EnvoyerMail()
	{
		props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
                        @Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(expidideur, motPasse);
			}
		  });
	}
	
	public Boolean EnvoyerdEmail(String recepteur,String nomExpediteur,String subject,
                String content ,Attachment attachment,Multipart multipart,
                List<Fichier> fileToAttachments  ){
		try {
			Message msg = new MimeMessage(session);
			try {
				msg.setFrom(new InternetAddress(expidideur," "+nomExpediteur+" "+expidideur));
			} catch (UnsupportedEncodingException e) {
			}
			msg.setRecipients(Message.RecipientType.TO,InternetAddress.parse(recepteur));
			msg.setSubject(subject);
                        multipart= Attachment.ajouterFichiers(multipart, fileToAttachments);

                        // faire la page html
                        String htmlContent="<h3>"+content+"</h3>";
                        BodyPart htmlBodyPart = new MimeBodyPart(); //1
                        htmlBodyPart.setContent(htmlContent , "text/html; charset=utf-8"); //1
                        multipart.addBodyPart(htmlBodyPart); //1
                        msg.setContent(multipart);//1
			Transport.send(msg);//1
                         System.out.println("Le mail a bien été envoyé au destinataire "+recepteur);//1
			return true;//1
		} catch (MessagingException e) {
			return false;
			
		}
        }
}
		
	
    

