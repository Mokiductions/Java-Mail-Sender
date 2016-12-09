/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamail;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Miquel Ginés Borràs
 */
public class MailSender {

    private String username;
    private String password;
    private String subject;
    private String body;
    private String destination;
    private final String CCO = "lander.user.services@gmail.com"; // Copia oculta fija

    /**
     * Constructor vacío
     */
    public MailSender() {
    }

    /**
     * Constructor con los datos de inicio de sesión del emisor por parámetros.
     *
     * @param username String - Nombre de inicio de sesión
     * @param password String - Contraseña de inicio de sesión
     */
    public MailSender(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public MailSender(String username, String password, String destination,
            String subject, String body) {
        this.username = username;
        this.password = password;
        this.destination = destination;
        this.subject = subject;
        this.body = body;
    }

    /**
     * Establece el nombre de inicio de sesión del emisor.
     *
     * @param username
     */
    public void setSourceMail(String username) {
        this.username = username;
    }

    /**
     * Establece la contraseña de inicio de sesión del emisor.
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Establece el destinatario del correo.
     *
     * @param destination
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * Establece el asunto del correo.
     *
     * @param subject
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * Establece el cuerpo del correo.
     *
     * @param body
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * Método para enviar el correo.
     * @throws javax.mail.MessagingException
     */
    public void send() throws MessagingException {
        // Establece las propiedades de la conexión.
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // Se conecta a la cuenta de emisión del correo.
        Session session;
        session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        
            // Prepara el correo con los datos establecidos.
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destination));
            message.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(CCO));
            message.setSubject(subject);
            message.setText(body);

            // Envía el correo
            Transport.send(message);

            System.out.println("Mensaje envíado correctamente.");
    }

}