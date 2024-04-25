package cc103.assignment1;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        String username = "salimbagat1124@gmail.com";
        String password = "redacted";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.ssl.enable", "true");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("salimbagat1124@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("toolong972@gmail.com"));
            message.setSubject("Test email");
            message.setText("Test email");

            Transport.send(message);

            System.out.println("sent!");
        } catch (MessagingException e) {
            System.out.println(e.toString());
        }
    }
}