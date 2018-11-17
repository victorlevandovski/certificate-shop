package com.victorlevandovski.catalog.domain.model.certificate;

import com.victorlevandovski.common.domain.model.ValueObject;

public class CertificateDeliveryOptions extends ValueObject {

    private boolean electronicDeliveryAvailable;
    private boolean postalDeliveryAvailable;

    CertificateDeliveryOptions(boolean electronicDeliveryAvailable, boolean postalDeliveryAvailable) {
        if (!electronicDeliveryAvailable && !postalDeliveryAvailable) {
            throw new IllegalArgumentException("At least one delivery method must be available");
        }

        this.electronicDeliveryAvailable = electronicDeliveryAvailable;
        this.postalDeliveryAvailable = postalDeliveryAvailable;
    }

    public boolean isElectronicDeliveryAvailable() {
        return this.electronicDeliveryAvailable;
    }

    public boolean isPostalDeliveryAvailable() {
        return this.postalDeliveryAvailable;
    }
}
