package com.victorlevandovski.catalog.application.query.certificate;

import com.victorlevandovski.catalog.domain.model.certificate.Certificate;

import java.math.BigDecimal;

public class CertificateData {

    private String accountId;
    private String certificateId;
    private String title;
    private String description;
    private BigDecimal priceAmount;
    private String priceCurrency;
    private boolean electronicDeliveryAvailable;
    private boolean postalDeliveryAvailable;
    private boolean availableForSale;

    public CertificateData() {
        super();
    }

    public static CertificateData fromCertificate(Certificate certificate) {
        CertificateData data = new CertificateData();
        data.accountId = certificate.accountId().id();
        data.certificateId = certificate.certificateId().id();
        data.title = certificate.title();
        data.description = certificate.description();
        data.priceAmount = certificate.price().amount();
        data.priceCurrency = certificate.price().currency().code();
        data.electronicDeliveryAvailable = certificate.deliveryOptions().isElectronicDeliveryAvailable();
        data.postalDeliveryAvailable = certificate.deliveryOptions().isPostalDeliveryAvailable();
        data.availableForSale = certificate.isAvailableForSale();

        return data;
    }

    public String accountId() {
        return this.accountId;
    }

    public String certificateId() {
        return this.certificateId;
    }

    public String title() {
        return this.title;
    }

    public String description() {
        return this.description;
    }

    public BigDecimal priceAmount() {
        return this.priceAmount;
    }

    public String priceCurrency() {
        return this.priceCurrency;
    }

    public boolean isElectronicDeliveryAvailable() {
        return this.electronicDeliveryAvailable;
    }

    public boolean isPostalDeliveryAvailable() {
        return this.postalDeliveryAvailable;
    }

    public boolean isAvailableForSale() {
        return this.availableForSale;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public void setCertificateId(String certificateId) {
        this.certificateId = certificateId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPriceAmount(BigDecimal priceAmount) {
        this.priceAmount = priceAmount;
    }

    public void setPriceCurrency(String priceCurrency) {
        this.priceCurrency = priceCurrency;
    }

    public void setElectronicDeliveryAvailable(boolean electronicDeliveryAvailable) {
        this.electronicDeliveryAvailable = electronicDeliveryAvailable;
    }

    public void setPostalDeliveryAvailable(boolean postalDeliveryAvailable) {
        this.postalDeliveryAvailable = postalDeliveryAvailable;
    }

    public void setAvailableForSale(boolean availableForSale) {
        this.availableForSale = availableForSale;
    }
}
