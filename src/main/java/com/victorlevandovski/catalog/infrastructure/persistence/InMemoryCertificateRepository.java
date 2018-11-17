package com.victorlevandovski.catalog.infrastructure.persistence;

import com.victorlevandovski.catalog.domain.model.account.AccountId;
import com.victorlevandovski.catalog.domain.model.certificate.Certificate;
import com.victorlevandovski.catalog.domain.model.certificate.CertificateId;
import com.victorlevandovski.catalog.domain.model.certificate.CertificateRepository;

import java.util.HashMap;
import java.util.Map;

public class InMemoryCertificateRepository implements CertificateRepository {

    private Map<String, Certificate> certificates;

    public InMemoryCertificateRepository() {
        this.certificates = new HashMap<>();
    }

    @Override
    public void add(Certificate certificate) {
        String key = this.keyOf(certificate.accountId(), certificate.certificateId());

        if (this.certificates.containsKey(key)) {
            throw new IllegalStateException("Certificate with key " + key + " already exists in repository");
        }

        this.certificates.put(key, certificate);
    }

    @Override
    public void remove(Certificate certificate) {
        this.certificates.remove(this.keyOf(certificate.accountId(), certificate.certificateId()));
    }

    @Override
    public Certificate certificateOfId(AccountId accountId, CertificateId certificateId) {
        return this.certificates.get(this.keyOf(accountId, certificateId));
    }

    private String keyOf(AccountId accountId, CertificateId certificateId) {
        return accountId.id() + ":" + certificateId.id();
    }
}
