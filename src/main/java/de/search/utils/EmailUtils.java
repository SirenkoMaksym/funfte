/*
 * created by ьфч$
 */


package de.search.utils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class EmailUtils {

    private static final String TO = "brute1988@gmail.com"; // Замените на реальный адрес получателя
    private static final String FROM = "brute1988@gmail.com";
    private static final String HOST = "smtp.gmail.com";
    private static final String PORT = "587";
    private static final String USERNAME = "brute1988@gmail.com";
    private static final String PASSWORD = "takn pvzc kppn wzye";

    public static void sendEmail(String body) {
        // Настройка свойств для почтового сервера
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", HOST);
        properties.put("mail.smtp.port", PORT);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // Создание сессии с аутентификацией
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, PASSWORD);
            }
        });

        try {
            // Создание сообщения
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(FROM));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(TO));

            // Генерация заголовка с текущей датой и временем
            String dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
            String subject = "Дата отправки - " + dateTime;
            message.setSubject(subject);
            message.setText(body);

            // Отправка сообщения
            Transport.send(message);
            System.out.println("Message sent successfully!");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

}

