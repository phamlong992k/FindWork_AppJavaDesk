/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DTO.Email;
import java.util.Properties;
import java.util.Random;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class EmailDAO {
    private String mailHost="smtp.gmail.com";
    private String user;
    private String password;
    private Session session;
    private int code=-1;
    public EmailDAO(Email email){
        this.user=email.getUser();
        this.password=email.getPassword();
        Properties props= new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.smtp.host", mailHost);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.debug", "true");
        props.put("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.quitwait", "false");
        passwordAuthen(props);
            
    }
    private void passwordAuthen(Properties props){
        session= Session.getDefaultInstance(props,new Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(user, password);
            }
        }); 
    }
    public int EmailSend(String toEmail){
        try{
            MimeMessage message= new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipients(Message.RecipientType.TO, toEmail);
            code=makeCode();
            message.setSubject("[FastJob] Please confirm your email by this code below !");
            message.setText("This is your code: "+code);
            Transport.send(message);
        }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Can not send email. Please check your email");
        }
        return code;
    }
    private int makeCode(){
        Random random= new Random();
        return random.nextInt(1000);
    }
}
