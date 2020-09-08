package tn.bfi.spring.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements IEmailService  {

	
    static Properties properties;
    static Session session;
    static MimeMessage message;

    public String email = "belhajaliyasser@gmail.com";
    public String password = "yasser2013";

 
 
    @Override
    public boolean SendingEmail(Long idAb) {
    	

    	try {

        // Step1 : Préparer les mail server properties
        properties = System.getProperties();
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.starttls.required", "true");


        // Step2 : get mail session
        session = Session.getDefaultInstance(properties, null);
        message = new MimeMessage(session);
        message.addRecipient(Message.RecipientType.TO, new InternetAddress("yasser.belhajali@esprit.tn"));
        message.setFrom( new InternetAddress(email));
        message.setSubject("Demande rendez-vous ");
        String emailBody ="ahmed";
        message.setContent(emailBody,"hello");

        // Step3 : Send the mail
        Transport transport = session.getTransport("smtp");
        transport.connect("smtp.gmail.com", email, password);
        transport.sendMessage(message, message.getAllRecipients());
        
        transport.close();
        
    } catch (Exception ex) {
        System.err.println("test"+ex.getMessage());
    }
    	return true;
    
}

}
