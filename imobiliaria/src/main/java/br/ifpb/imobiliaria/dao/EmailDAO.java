package br.ifpb.imobiliaria.dao;

import br.ifpb.imobiliaria.config.EmailConfig;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailDAO {
    public void enviarEmail(String destinatario, String assunto, String corpo){
        String username = EmailConfig.getProps().getProperty("mail.username");
        String password = EmailConfig.getProps().getProperty("mail.password");

        System.out.println(username);
        System.out.println(password);


        Session session = Session.getInstance(EmailConfig.getProps(), new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            message.setSubject(assunto);
            message.setText(corpo);

            Transport.send(message);

            System.out.println("E-mail enviado com sucesso!");
        }catch (MessagingException e){
            throw new RuntimeException("Erro ao enviar e-mail", e);
        }
    }

}
