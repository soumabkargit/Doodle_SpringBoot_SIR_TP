/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.istic.sir.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;

/**
 *
 * @author soumabkar
 */
public class Attachment {
    Multipart multipart;
    String file;
    BodyPart messageBodyPart;

    public BodyPart getMessageBodyPart() {
        return messageBodyPart;
    }

    public void setMessageBodyPart(BodyPart messageBodyPart) {
        this.messageBodyPart = messageBodyPart;
    }
    ArrayList<String> listAttachments;

    public Attachment(Multipart multipart, String file, ArrayList<String> listAttachment) {
        this.multipart = multipart;
        this.file = file;
        this.listAttachments =listAttachment;
        
    }

    public Attachment() {
    }

    public Multipart getMultipart() {
        return multipart;
    }

    public void setMultipart(Multipart multipart) {
        this.multipart = multipart;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public ArrayList<String> getListAttachments() {
        return listAttachments;
    }

    public void setListAttachments(ArrayList<String> listAttachments) {
        this.listAttachments = listAttachments;
    }
    
    
    
  public static void ajouterFichier(Multipart multipart, String file, String fileName) throws MessagingException
                {
                    DataSource source = new FileDataSource(file);
                    BodyPart messageBodyPart = new MimeBodyPart();        
                    messageBodyPart.setDataHandler(new DataHandler(source));
                    messageBodyPart.setFileName(fileName);
                    multipart.addBodyPart(messageBodyPart);
                }
  
  public static Multipart ajouterFichiers(Multipart multipart,
          List<Fichier> fileToAttachments ) throws MessagingException
                { 
                   Iterator<Fichier> iterator = fileToAttachments.iterator();
	           while(iterator.hasNext()) {
	    	    Fichier files = iterator.next();
                       System.out.println("  "+files.getCheminFichier()+"c'est ça qui est quoi!!!");
	    	    DataSource dataSource = new FileDataSource(files.getCheminFichier());
                    BodyPart messageBodyPart = files.getBodyPart(); 
                    messageBodyPart.setDataHandler(new DataHandler(dataSource));
                    messageBodyPart.setFileName(files.getNomFichier());
                    multipart.addBodyPart(messageBodyPart);
                    System.out.println("  "+files.getBodyPart()+"c'est ça qui est là!!!");
	    }
                   return multipart;
                }
  
     
     
    
}
