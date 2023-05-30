package com.jihwan.soccer.mail.model.dto;

public class MailCertDTO {

    private String certKey;
    private String certEmail;

    public MailCertDTO(){}

    public MailCertDTO(String certKey, String certEmail) {
        this.certKey = certKey;
        this.certEmail = certEmail;
    }

    public String getCertKey() {
        return certKey;
    }

    public void setCertKey(String certKey) {
        this.certKey = certKey;
    }

    public String getCertEmail() {
        return certEmail;
    }

    public void setCertEmail(String certEmail) {
        this.certEmail = certEmail;
    }

    @Override
    public String toString() {
        return "MailDTO{" +
                "certKey='" + certKey + '\'' +
                ", certEmail='" + certEmail + '\'' +
                '}';
    }
}
