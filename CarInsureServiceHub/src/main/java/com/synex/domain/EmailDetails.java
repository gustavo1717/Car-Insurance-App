package com.synex.domain;

import jakarta.activation.DataSource;

public class EmailDetails {

    private String recipient;
    private String msgBody;
    private String subject;
    private DataSource attachment;

    public EmailDetails() {
    }

    public EmailDetails(String recipient, String msgBody, String subject, DataSource attachment) {
        this.recipient = recipient;
        this.msgBody = msgBody;
        this.subject = subject;
        this.attachment = attachment;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getMsgBody() {
        return msgBody;
    }

    public void setMsgBody(String msgBody) {
        this.msgBody = msgBody;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public DataSource getAttachment() {
        return attachment;
    }

    public void setAttachment(DataSource attachment) {
        this.attachment = attachment;
    }
}
