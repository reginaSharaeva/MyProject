package ru.kpfu.itis.toyshop.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

/**
 * Created by Регина on 24.03.2016.
 */
@Component
public class MailSender {

    @Autowired
    JavaMailSender mailSender;

    @Autowired
    SimpleMailMessage templateMessage;

    public void sendMail(String setTo, String mail) {

        SimpleMailMessage mailMessage = new SimpleMailMessage(templateMessage);

        mailMessage.setTo(setTo);

        mailMessage.setText("Для регистрации перейдите по ссылке" + mail);
        try {
            mailSender.send(mailMessage);
            System.out.println("Mail sended");
        } catch (MailException mailException) {
            System.out.println("Mail send failed.");
            mailException.printStackTrace();
        }
    }
}
