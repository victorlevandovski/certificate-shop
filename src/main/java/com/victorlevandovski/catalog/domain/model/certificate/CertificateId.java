package com.victorlevandovski.catalog.domain.model.certificate;

import com.victorlevandovski.common.domain.model.Identity;

public class CertificateId extends Identity {

    public CertificateId(String id) {
        super(id);
    }

    @Override
    protected int hashOddValue() {
        return 37935;
    }

    @Override
    protected int hashPrimeValue() {
        return 59;
    }
}
