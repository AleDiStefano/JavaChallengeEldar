package com.Eldar.JavaChallenge_Ej2.service;

import org.springframework.stereotype.Service;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

@Service
public class EmailService {

    public static String emailFrom = "noreplyecommerseprogramacion@gmail.com";
    public static String passwordFrom = "omncltgefpougmzi";
    public String mailTo;
    public String subject;
    public String content;

    public Properties mProperties;
    public Session mSession;
    public MimeMessage mCorreo;


    public void createEmail(String mailTo, String subject, String content) throws MessagingException {

        mProperties = new Properties();

        // Simple mail transfer protocol
        mProperties.put("mail.smtp.host", "smtp.gmail.com");
        mProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        mProperties.setProperty("mail.smtp.starttls.enable", "true");
        mProperties.setProperty("mail.smtp.port", "587");
        mProperties.setProperty("mail.smtp.user",emailFrom);
        mProperties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        mProperties.setProperty("mail.smtp.auth", "true");

        mSession = Session.getDefaultInstance(mProperties);


        mCorreo = new MimeMessage(mSession);
        mCorreo.setFrom(new InternetAddress(emailFrom));
        mCorreo.setRecipient(Message.RecipientType.TO, new InternetAddress(mailTo));
        mCorreo.setSubject(subject);
        mCorreo.setText(content, "ISO-8859-1", "html");
    }

    public void sendEmail() throws MessagingException {
        Transport mTransport = mSession.getTransport("smtp");
        mTransport.connect(emailFrom, passwordFrom);
        mTransport.sendMessage(mCorreo, mCorreo.getRecipients(Message.RecipientType.TO));
        mTransport.close();
    }
}
