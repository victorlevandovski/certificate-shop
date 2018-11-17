package com.victorlevandovski.catalog.domain.model.certificate;

import com.victorlevandovski.catalog.domain.model.account.AccountId;
import com.victorlevandovski.common.domain.model.DomainEvent;
import com.victorlevandovski.common.util.money.Money;

import java.util.Date;

public class CertificateCreated implements DomainEvent {

    private AccountId accountId;
    private CertificateId certificateId;
    private String title;
    private String description;
    private Money price;
    private CertificateDeliveryOptions deliveryOptions;
    private boolean availableForSale;
    private Date occurredOn;

    public CertificateCreated(
        AccountId accountId,
        CertificateId certificateId,
        String title,
        String description,
        Money price,
        CertificateDeliveryOptions deliveryOptions,
        boolean availableForSale) {

        this.accountId = accountId;
        this.certificateId = certificateId;
        this.title = title;
        this.description = description;
        this.price = price;
        this.deliveryOptions = deliveryOptions;
        this.availableForSale = availableForSale;
        this.occurredOn = new Date();
    }

    public AccountId accountId() {
        return this.accountId;
    }

    public CertificateId certificateId() {
        return this.certificateId;
    }

    public String title() {
        return this.title;
    }

    public String description() {
        return this.description;
    }

    public Money price() {
        return this.price;
    }

    public CertificateDeliveryOptions deliveryOptions() {
        return this.deliveryOptions;
    }

    public boolean isAvailableForSale() {
        return this.availableForSale;
    }

    @Override
    public Date occurredOn() {
        return this.occurredOn;
    }
}
