package com.victorlevandovski.catalog.application.command.certificate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


import com.victorlevandovski.catalog.domain.model.account.AccountId;
import com.victorlevandovski.catalog.domain.model.certificate.Certificate;
import com.victorlevandovski.catalog.domain.model.certificate.CertificateId;
import com.victorlevandovski.catalog.domain.model.certificate.CertificateRepository;
import com.victorlevandovski.catalog.infrastructure.persistence.InMemoryCertificateRepository;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class AddCertificateCommandTest {

    @Test
    void testAddCertificate() {
        CertificateRepository certificateRepository = new InMemoryCertificateRepository();
        AddCertificateCommandHandler commandHandler = new AddCertificateCommandHandler(certificateRepository);

        AddCertificateCommand command = new AddCertificateCommand(
                "account-1",
                "New Certificate",
                "The best certificate ever",
                new BigDecimal(100),
                "EUR",
                true,
                true,
                true
        );

        AddCertificateCommandResult commandResult = new AddCertificateCommandResult();

        commandHandler.handle(command, commandResult);

        assertNotNull(commandResult.certificateId());
        assertNotEquals(commandResult.certificateId(), "");


        Certificate certificate = certificateRepository.certificateOfId(
                new AccountId("account-1"),
                new CertificateId(commandResult.certificateId())
        );

        assertEquals(certificate.accountId().id(), "account-1");
        assertEquals(certificate.certificateId().id(), commandResult.certificateId());
        assertEquals(certificate.title(), "New Certificate");
        assertEquals(certificate.description(), "The best certificate ever");
        assertEquals(certificate.price().amount().toString(), "100");
        assertEquals(certificate.price().currency().code(), "EUR");
        assertTrue(certificate.deliveryOptions().isElectronicDeliveryAvailable());
        assertTrue(certificate.deliveryOptions().isPostalDeliveryAvailable());
        assertTrue(certificate.isAvailableForSale());
    }
}
