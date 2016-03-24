package ru.kpfu.itis.toyshop.sender;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

/**
 * Created by Регина on 24.03.2016.
 */
public class MailSender {
    public static void main( String[] args ) {
        try (GenericXmlApplicationContext context = new GenericXmlApplicationContext()) {
            context.load("classpath:applicationContext.xml");
            context.refresh();
            JavaMailSender mailSender = context.getBean("mailSender", JavaMailSender.class);
            SimpleMailMessage templateMessage = context.getBean("templateMessage", SimpleMailMessage.class);

            // Создаём потокобезопасную копию шаблона.
            SimpleMailMessage mailMessage = new SimpleMailMessage(templateMessage);

            //TODO: Сюда напишите свой e-mail получателя.
            mailMessage.setTo("ouhb93u4hng9hndf9@mail.ru");

            mailMessage.setText("Привет, товарищи. Присылаю вам письмо...");
            try {
                mailSender.send(mailMessage);
                System.out.println("Mail sended");
            } catch (MailException mailException) {
                System.out.println("Mail send failed.");
                mailException.printStackTrace();
            }
        }
    }
}
