package com.victorlevandovski.catalog.application.query.certificate;

import com.victorlevandovski.catalog.domain.model.certificate.Certificate;

public class CertificateData {

    private String accountId;
    private String certificateId;

    public CertificateData() {
        super();
    }

    public static CertificateData fromCertificate(Certificate certificate) {
        CertificateData data = new CertificateData();
        data.accountId = certificate.accountId().id();
        data.certificateId = certificate.certificateId().id();

        return data;
    }

    public String AccountId() {
        return accountId;
    }

    public String certificateId() {
        return certificateId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public void setCertificateId(String certificateId) {
        this.certificateId = certificateId;
    }
}
