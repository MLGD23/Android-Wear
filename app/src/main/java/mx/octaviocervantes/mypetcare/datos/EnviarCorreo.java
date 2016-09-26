package mx.octaviocervantes.mypetcare.datos;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Created by Tavo on 22/09/2016.
 */
public class EnviarCorreo {

    Properties properties = new Properties();
    private String sCorreoReceptor;
    private String sMensajeCorreo;
    private String sNombreCorreo;
    private String sCorreo = "ocervantesruiz@gmail.com";
    private String sContraseña = "Versa2014#";
    private Session session;

    public EnviarCorreo(String sNombreCorreo, String sCorreoReceptor, String sMensajeCorreo){
        this.sCorreoReceptor = sCorreoReceptor;
        this.sMensajeCorreo = sMensajeCorreo;
        this.sNombreCorreo = sNombreCorreo;
    }

    private void iniciar(){
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        session = Session.getDefaultInstance(properties, null);
    }

    public void enviar(){

        iniciar();

        try {
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(sCorreo));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(sCorreoReceptor));
            msg.setSubject("Correo de contacto: " + sNombreCorreo);
            msg.setContent(sMensajeCorreo, "text/html");

            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", 587, sCorreo, sContraseña);
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();
        }catch (MessagingException ex){
            ex.printStackTrace();
        }
    }
}
