package com.victorlevandovski.catalog.application.certificate;

public class AddCertificateCommandResult {

    private String certificateId;

    public AddCertificateCommandResult() {
        super();
    }

    public String certificateId() {
        return this.certificateId;
    }

    public void setCertificateId(String certificateId) {
        this.certificateId = certificateId;
    }
}
