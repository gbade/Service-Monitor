package com.logger;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;
import java.io.*;

/*
  To use this program, change values for the following three constants,

    SMTP_HOST_NAME -- Has your SMTP Host Name
    SMTP_AUTH_USER -- Has your SMTP Authentication UserName
    SMTP_AUTH_PWD  -- Has your SMTP Authentication Password

  Next change values for fields

  emailMsgTxt  -- Message Text for the Email
  emailSubjectTxt  -- Subject for email
  emailFromAddress -- Email Address whose name will appears as "from" address

  Next change value for "emailList".
  This String array has List of all Email Addresses to Email Email needs to be sent to.


*/

public class SendMailUsingAuthentication
{

  private static final String SMTP_HOST_NAME = "10.10.10.3";
  private static final String SMTP_AUTH_USER = "app@paycom-ng.com";
  private static final String SMTP_AUTH_PWD  = "simfonie";

  private static final String emailMsgTxt      = "This is just a test. Hope it works.";
  private static final String emailSubjectTxt  = "Alert Sending test";
  private static final String emailFromAddress = "no-reply@paycom-ng.com";

  // Add List of Email address to who email needs to be sent to
  private static final String[] emailList = {"debo_ay@yahoo.co.uk", "dotun_ay@yahoo.co.uk", "gbadebo.ayan@gmail.com"};

  public static void main(String args[]) throws Exception
  {
    SendMailUsingAuthentication smtpMailSender = new SendMailUsingAuthentication();
    smtpMailSender.postMail( emailList, emailSubjectTxt, emailMsgTxt, emailFromAddress);
    System.out.println("Sucessfully Sent mail to All Users");
  }

  public void postMail( String recipients[ ], String subject,
                            String message , String from) throws MessagingException
  {
    boolean debug = false;

     //Set the host smtp address
     Properties props = new Properties();
     props.put("mail.smtp.host", SMTP_HOST_NAME);
     props.put("mail.smtp.auth", "true");

    Authenticator auth = new SendMailUsingAuthentication.SMTPAuthenticator();
    Session session = Session.getInstance(props, auth);

    session.setDebug(debug);

    // create a message
    Message msg = new MimeMessage(session);

    // set the from and to address
    InternetAddress addressFrom = new InternetAddress(from);
    msg.setFrom(addressFrom);

    InternetAddress[] addressTo = new InternetAddress[recipients.length];
    for (int i = 0; i < recipients.length; i++)
    {
        addressTo[i] = new InternetAddress(recipients[i]);
    }
    msg.setRecipients(Message.RecipientType.TO, addressTo);


    // Setting the Subject and Content Type
    msg.setSubject(subject);
    msg.setContent(message, "text/plain");
    Transport.send(msg);
 }


/**
* SimpleAuthenticator is used to do simple authentication
* when the SMTP server requires it.
*/
private class SMTPAuthenticator extends javax.mail.Authenticator
{

    public PasswordAuthentication getPasswordAuthentication()
    {
        String username = SMTP_AUTH_USER;
        String password = SMTP_AUTH_PWD;
        return new PasswordAuthentication(username, password);
    }
}

}


