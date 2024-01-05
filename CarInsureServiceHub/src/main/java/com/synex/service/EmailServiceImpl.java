package com.synex.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.synex.domain.EmailDetails;

import jakarta.mail.internet.MimeMessage;



@Service
public class EmailServiceImpl implements EmailService {

	@Autowired private JavaMailSender javaMailSender;
	 
    @Value("${spring.mail.username}") private String sender;
 
   /* public String sendSimpleMail(EmailDetails emailDetails)
    {
 
        // Try block to check for exceptions
        try {
 
            // Creating a simple mail message
            SimpleMailMessage mailMessage = new SimpleMailMessage();
 
            // Setting up necessary details
            mailMessage.setFrom(sender);
            mailMessage.setTo(emailDetails.getRecipient());
            mailMessage.setText(emailDetails.getMsgBody());
            mailMessage.setSubject(emailDetails.getSubject());
 
            // Sending the mail
            System.out.println(mailMessage);
            System.out.println(emailDetails.getRecipient());

            javaMailSender.send(mailMessage);
            return "Mail Sent Successfully...";
        }
 
        // Catch block to handle the exceptions
        catch (Exception e) {
        	System.out.println(e);
            return "Error while Sending Mail";
        }
    }*/
    
    public String sendMailWithAttachment(EmailDetails emailDetails) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

            helper.setFrom(sender);
            helper.setTo(emailDetails.getRecipient());
            helper.setSubject(emailDetails.getSubject());
            helper.setText(emailDetails.getMsgBody());

            // Add the attachment
            if (emailDetails.getAttachment() != null) {
                FileSystemResource attachment = (FileSystemResource) emailDetails.getAttachment();
                File attachmentFile = attachment.getFile();  // Get the File object
                String attachmentPath = attachmentFile.getAbsolutePath();
                System.out.println("Attachment File Path: " + attachmentPath);
                helper.addAttachment("filename.pdf", attachmentFile);
            }

            javaMailSender.send(mimeMessage);
            return "Mail Sent Successfully...";
        } catch (Exception e) {
            System.out.println("Error while Sending Mail: " + e.getMessage());
            e.printStackTrace();
            return "Error while Sending Mail";
        }
    }




@Override
public String sendSimpleMail(EmailDetails emailDetails) {
	// TODO Auto-generated method stub
	return null;
}

	
}
