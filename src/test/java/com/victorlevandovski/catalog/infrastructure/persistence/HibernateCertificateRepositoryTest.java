package com.victorlevandovski.catalog.infrastructure.persistence;

import com.victorlevandovski.catalog.domain.model.account.AccountId;
import com.victorlevandovski.catalog.domain.model.certificate.Certificate;
import com.victorlevandovski.catalog.domain.model.certificate.CertificateDeliveryOptions;
import com.victorlevandovski.catalog.domain.model.certificate.CertificateId;
import com.victorlevandovski.catalog.infrastructure.InfrastructureTest;
import com.victorlevandovski.common.util.money.Currency;
import com.victorlevandovski.common.util.money.Money;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HibernateCertificateRepositoryTest extends InfrastructureTest {

    @Test
    void repositorySavesNewCertificate() {
        HibernateCertificateRepository repository = new HibernateCertificateRepository();
        repository.setSessionProvider(this.sessionProvider);

        repository.add(this.certificate());

        Certificate savedCertificate = repository.certificateOfId(
                new AccountId("test-account-1"),
                new CertificateId("test-certificate-1")
        );

        assertEquals(savedCertificate.accountId().id(), "test-account-1");
        assertEquals(savedCertificate.certificateId().id(), "test-certificate-1");
        assertEquals(savedCertificate.title(), "New certificate");
        assertEquals(savedCertificate.description(), "The best certificate ever");
        assertEquals(savedCertificate.price().amount().toString(), "100");
        assertEquals(savedCertificate.price().currency().code(), "EUR");
        assertTrue(savedCertificate.deliveryOptions().isElectronicDeliveryAvailable());
        assertTrue(savedCertificate.deliveryOptions().isPostalDeliveryAvailable());
        assertTrue(savedCertificate.isAvailableForSale());
    }

    private Certificate certificate() {
        return new Certificate(
                new AccountId("test-account-1"),
                new CertificateId("test-certificate-1"),
                "New certificate",
                "The best certificate ever",
                new Money(new BigDecimal(100), Currency.EUR),
                new CertificateDeliveryOptions(true, true),
                true
        );
    }
}
