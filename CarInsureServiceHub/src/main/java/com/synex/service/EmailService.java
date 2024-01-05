package com.synex.service;

import com.synex.domain.EmailDetails;

public interface EmailService {
	String sendSimpleMail(EmailDetails emailDetails);
    String sendMailWithAttachment(EmailDetails emailDetails);
	
	
}
