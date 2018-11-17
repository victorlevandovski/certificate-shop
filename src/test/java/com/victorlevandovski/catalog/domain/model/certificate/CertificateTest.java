package com.victorlevandovski.catalog.domain.model.certificate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.victorlevandovski.catalog.domain.model.account.AccountId;
import com.victorlevandovski.common.util.money.Currency;
import com.victorlevandovski.common.util.money.Money;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class CertificateTest {

    @Test
    void testCreateCertificate() {
        Certificate certificate = new Certificate(
                new AccountId("account-1"),
                new CertificateId("certificate-1"),
                "New certificate",
                "The best certificate ever",
                new Money(new BigDecimal(100), Currency.EUR),
                new CertificateDeliveryOptions(true, true),
                true
        );

        assertEquals(certificate.accountId().id(), "account-1");
        assertEquals(certificate.certificateId().id(), "certificate-1");
        assertEquals(certificate.title(), "New certificate");
        assertEquals(certificate.description(), "The best certificate ever");
        assertEquals(certificate.price().amount().toString(), "100");
        assertEquals(certificate.price().currency().code(), "EUR");
        assertTrue(certificate.deliveryOptions().isElectronicDeliveryAvailable());
        assertTrue(certificate.deliveryOptions().isPostalDeliveryAvailable());
        assertTrue(certificate.isAvailableForSale());
    }
}
