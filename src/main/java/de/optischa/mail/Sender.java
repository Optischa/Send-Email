package de.optischa.mail;

import de.optischa.mail.components.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class Sender {

    public static void sendEmail(String fromEmail, String toEmail, String title, String body, Session session) {
        Message message = new MimeMessage(session);
        sendMessage(message, body, title, toEmail, fromEmail);
    }

    public static void sendArrayEmail(String fromEmail, List<String> toEmails, String title, String body, Session session) {
        for (String toEmail : toEmails) {
            Message message = new MimeMessage(session);
            sendMessage(message, body, title, toEmail, fromEmail);
        }
    }

    public static void sendArrayEmail(String fromEmail, List<String> toEmails, String title, List<Component> components, Session session) {
        for (String toEmail : toEmails) {
            Message message = new MimeMessage(session);
            sendMessage(message, getBodyFromComponent(components), title, toEmail, fromEmail);
        }
    }

    public static void sendEmail(String fromEmail, String toEmail, String title, List<Component> components, Session session) {
        Message message = new MimeMessage(session);
        sendMessage(message, getBodyFromComponent(components), title, toEmail, fromEmail);
    }

    private static String getBodyFromComponent(List<Component> components) {
        StringBuilder stringBuilder = new StringBuilder();
        for(Component component : components) {
            if (component.file() != null) {
                InputStream htmlFile = Sender.class.getClassLoader().getResourceAsStream(component.file());
                String result = new BufferedReader(new InputStreamReader(htmlFile))
                        .lines().collect(Collectors.joining("\n"));
                stringBuilder.append(result);
            }
            if (component.body() != null) {
                stringBuilder.append(component.body());
            }
        }
        return stringBuilder.toString();
    }

    private static void sendMessage(Message message, String body, String title, String toEmail, String fromEmail) {
        try {
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(
                    Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject(title);

            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(body, "text/html");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);

            message.setContent(multipart);
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
