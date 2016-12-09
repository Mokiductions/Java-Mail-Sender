/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamail;

import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;

/**
 *
 * @author Miquel Ginés Borràs
 */
public class JavaMail {

    /**
     * Esta proyecto está preparado para enviar correos desde una dirección
     * de GMail.
     * 
     * Hay que descargar las librerías de JavaMail API, desde el siguiente 
     * enlace https://java.net/projects/javamail/pages/Home 
     * 
     * Una vez descargadas basta con incluirlas al proyecto, y la clase 
     * debería funcionar correctamente. Si da errores de autenticación, hay que
     * activar al acceso de aplicaciones menos seguras en las opciones de la 
     * cuenta de GMail.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Datos de la cuenta de emisión del correo
        final String username = "lander.user.services@gmail.com";
        final String password = "Landergame1234";
        MailSender sender = new MailSender(username, password);
        
        // Establace el destinatario del correo
        sender.setDestination("ginesborrasm@gmail.com");
        // Establece el asunto del correo
        sender.setSubject("Prueba");
        // Establece el cuerpo del correo
        sender.setBody("Haga click <a href=\"http://www.google.es\">aquí</a> "
                + "para ir a GOOGLE.");
        
        try {
            // Envía el correo
            sender.send();
        } catch (MessagingException | UnsupportedEncodingException ex) {
            Logger.getLogger(JavaMail.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
