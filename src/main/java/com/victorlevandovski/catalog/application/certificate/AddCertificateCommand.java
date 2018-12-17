package com.victorlevandovski.catalog.application.certificate;

import com.victorlevandovski.common.application.command.Command;

import java.math.BigDecimal;

public class AddCertificateCommand implements Command {

    private String accountId;
    private String title;
    private String description;
    private BigDecimal priceAmount;
    private String priceCurrency;
    private boolean electronicDeliveryAvailable;
    private boolean postalDeliveryAvailable;
    private boolean availableForSale;

    public AddCertificateCommand(
            String accountId,
            String title,
            String description,
            BigDecimal priceAmount,
            String priceCurrency,
            boolean electronicDeliveryAvailable,
            boolean postalDeliveryAvailable,
            boolean availableForSale
    ) {
        this.accountId = accountId;
        this.title = title;
        this.description = description;
        this.priceAmount = priceAmount;
        this.priceCurrency = priceCurrency;
        this.electronicDeliveryAvailable = electronicDeliveryAvailable;
        this.postalDeliveryAvailable = postalDeliveryAvailable;
        this.availableForSale = availableForSale;
    }

    public String accountId() {
        return this.accountId;
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
}
