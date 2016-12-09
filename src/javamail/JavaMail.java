/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamail;

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
        final String username = "lander.user.services@gmail.com";
        final String password = "Landergame1234";
        MailSender sender = new MailSender(username, password);
        
        sender.setDestination("ginesborrasm@gmail.com");
        sender.setSubject("Prueba");
        sender.setBody("Mensaje de prueba.");
        
        try {
            sender.send();
        } catch (MessagingException ex) {
            Logger.getLogger(JavaMail.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
