package com.learn.learning.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class EmailDto {
    // @NotEmpty
    // private String from;
    @NotEmpty
    @Email
    private String to;
    @NotEmpty
    private String subject;
    @NotEmpty
    private String body;
    
    // public String getFrom() {
    //     return from;
    // }
    // public void setFrom(String from) {
    //     this.from = from;
    // }

    public String getTo() {
        return to;
    }
    public void setTo(String to) {
        this.to = to;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }

}
