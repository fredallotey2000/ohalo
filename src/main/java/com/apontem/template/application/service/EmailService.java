/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bvirtual.api.service;

/**
 *
 * @author Bsystems4
 */
import com.bvirtual.engine.Main;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailService {



    public static boolean sendMail(String emailAddress, String message) throws MessagingException {
        //Declare recipient's & sender's e-mail id.

        //Mention user name and password as per your configuration
        final String username = Main.engine.getProperties().getProperty("pinRequestEmail");
        final String password = Main.engine.getProperties().getProperty("pinRequestEmailPassword");
        
        final String smtpHost = Main.engine.getProperties().getProperty("smtpHost");
        final String smtpPort = Main.engine.getProperties().getProperty("smtpPort");
        final String smtpStartTls = Main.engine.getProperties().getProperty("smtpStartTls");
        
        final String smtpAuth = Main.engine.getProperties().getProperty("smtpAuth");

        //We are using relay.jangosmtp.net for sending emails
      //  String smtphost = "smtp.gmail.com";
        //Set properties and their values
        Properties propvls = new Properties();
        propvls.put("mail.smtp.auth", smtpAuth);
        propvls.put("mail.smtp.starttls.enable", smtpStartTls);
        propvls.put("mail.smtp.host", smtpHost);
        propvls.put("mail.smtp.port", smtpPort);
        //Create a Session object & authenticate uid and pwd
        Session sessionobj = Session.getInstance(propvls,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        //Create MimeMessage object & set values
        Message messageobj = new MimeMessage(sessionobj);
        messageobj.setFrom(new InternetAddress(username));
        messageobj.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailAddress));
        messageobj.setSubject(Main.engine.getProperties().getProperty("pinRequestEmailSubject"));
//        String message = getMessage(userPassword, userName);
//        messageobj.setContent(getMessage(userName, mobileNumber, country), "text/html");
         messageobj.setContent(message, "text/html");
        //Now send the message
        Transport.send(messageobj);
        return true;

    }
}
