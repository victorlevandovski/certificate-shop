package com.victorlevandovski.catalog.domain.model.certificate;

import com.victorlevandovski.catalog.domain.model.account.AccountId;

public interface CertificateRepository {

    void add(Certificate certificate);

    void remove(Certificate certificate);

    Certificate certificateOfId(AccountId accountId, CertificateId certificateId);
}
