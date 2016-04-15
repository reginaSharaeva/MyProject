package ru.kpfu.itis.toyshop.sender;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.InputStream;
import javax.mail.internet.MimeUtility;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class Mailing {
    private final String username = "mirigrushek2016@gmail.com";
    private final String password = "toy.shop";

    private boolean status = false;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean sendMail(String toEmail, String subject, String text) {
        Properties props = new Properties();
        String propFileName = "config.properties";
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
        try {
            props.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Session session = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
// multiple recipients           InternetAddress[] address = {new InternetAddress(to)};
//                               msg.setRecipients(Message.RecipientType.TO, address);
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject(subject);
            try {
                message.setText(MimeUtility.decodeText(text));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            Transport.send(message);
            return status = true;
        } catch (MessagingException e) {
            return status = false;
        }
    }
}