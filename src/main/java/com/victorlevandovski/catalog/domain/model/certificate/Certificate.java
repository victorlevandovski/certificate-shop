package com.victorlevandovski.catalog.domain.model.certificate;

import com.victorlevandovski.catalog.domain.model.account.AccountId;
import com.victorlevandovski.common.domain.model.Entity;
import com.victorlevandovski.common.util.money.Money;

public class Certificate extends Entity {

    private AccountId accountId;
    private CertificateId certificateId;
    private String title;
    private String description;
    private Money price;
    private CertificateDeliveryOptions deliveryOptions;
    private boolean availableForSale;

    public Certificate(
            AccountId accountId,
            CertificateId certificateId,
            String title,
            String description,
            Money price,
            CertificateDeliveryOptions deliveryOptions,
            boolean availableForSale) {

        super();

        this.setAccountId(accountId);
        this.setCertificateId(certificateId);
        this.setTitle(title);
        this.setDescription(description);
        this.setPrice(price);
        this.setDeliveryOptions(deliveryOptions);
        this.setAvailabilityForSale(availableForSale);
    }

    public AccountId accountId() {
        return this.accountId;
    }

    public CertificateId certificateId() {
        return  this.certificateId;
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
    public int hashCode() {
        return (5291 * 7) + this.accountId().hashCode() + this.certificateId().hashCode();
    }

    private void setAccountId(AccountId accountId) {
        this.assertNotNull(certificateId, "Account ID cannot be null");
        this.accountId = accountId;
    }

    private void setCertificateId(CertificateId certificateId) {
        this.assertNotNull(certificateId, "Certificate ID cannot be null");
        this.certificateId = certificateId;
    }

    private void setTitle(String title) {
        this.assertNotEmpty(title, "Certificate title cannot be empty");
        this.title = title;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    private void setPrice(Money price) {
        this.assertNotNull(price, "Certificate price cannot be null");
        this.price = price;
    }

    private void setDeliveryOptions(CertificateDeliveryOptions deliveryOptions) {
        this.assertNotNull(deliveryOptions, "Certificate delivery options cannot be null");
        this.deliveryOptions = deliveryOptions;
    }

    private void setAvailabilityForSale(boolean availableForSale) {
        this.availableForSale = availableForSale;
    }
}
