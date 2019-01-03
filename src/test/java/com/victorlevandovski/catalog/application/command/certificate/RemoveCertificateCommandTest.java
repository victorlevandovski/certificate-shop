package com.victorlevandovski.catalog.application.command.certificate;

import com.victorlevandovski.catalog.domain.model.account.AccountId;
import com.victorlevandovski.catalog.domain.model.certificate.Certificate;
import com.victorlevandovski.catalog.domain.model.certificate.CertificateDeliveryOptions;
import com.victorlevandovski.catalog.domain.model.certificate.CertificateId;
import com.victorlevandovski.catalog.domain.model.certificate.CertificateRepository;
import com.victorlevandovski.catalog.infrastructure.persistence.InMemoryCertificateRepository;
import com.victorlevandovski.common.util.money.Currency;
import com.victorlevandovski.common.util.money.Money;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class RemoveCertificateCommandTest {

    @Test
    void testRemoveCertificate() {
        CertificateRepository certificateRepository = new InMemoryCertificateRepository();

        certificateRepository.add(this.certificate());
        Certificate storedCertificate = certificateRepository.certificateOfId(
                new AccountId("account-1"),
                new CertificateId("certificate-1")
        );
        assertNotNull(storedCertificate);

        RemoveCertificateCommandHandler commandHandler = new RemoveCertificateCommandHandler(certificateRepository);
        RemoveCertificateCommand command = new RemoveCertificateCommand("account-1", "certificate-1");
        commandHandler.handle(command, null);

        Certificate removedCertificate = certificateRepository.certificateOfId(
                new AccountId("account-1"),
                new CertificateId("certificate-1")
        );

        assertNull(removedCertificate);
    }

    private Certificate certificate() {
        return new Certificate(
                new AccountId("account-1"),
                new CertificateId("certificate-1"),
                "New Certificate",
                "The best certificate ever",
                new Money(new BigDecimal(100), new Currency("EUR")),
                new CertificateDeliveryOptions(true, true),
                true
        );
    }
}
