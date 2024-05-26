package com.service;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Transport;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    
    public boolean sendEmail(String subject, String message, String to) {
        // Variable for gmail
        String host = "smtp.gmail.com";
        
        // Get the system properties
        Properties properties = System.getProperties();
        System.out.println("PROPERTIES " + properties);
        
        // Setting important information to properties object
        // Host set
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        
        // Step 1: To get the session object
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("adityanavgare162@gmail.com", "afat ppwb dmkl ymtr");
            }
        });
        
        session.setDebug(true);
        // Step 2: Compose the message [text, multimedia]
        MimeMessage m = new MimeMessage(session);
        String from = "adityanavgare162@gmail.com";
        
        try {
            // From email"
            m.setFrom(new InternetAddress(from));
            
            // Adding recipient to message
            m.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress(to));
            
            // Adding subject to message
            m.setSubject(subject);
            
            // Adding text to message
            m.setText(message);
            
            // Send 
            // Step 3: Send the message using Transport class
            Transport.send(m);
            
            System.out.println("Sent successfully!");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
		return false;
    }
}
