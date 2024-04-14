package com.company.pethackathon.email;

public interface EmailSender {
    void send(String to, String email, String token);
}
