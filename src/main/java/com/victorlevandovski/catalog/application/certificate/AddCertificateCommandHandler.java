package com.victorlevandovski.catalog.application.certificate;

import com.victorlevandovski.catalog.domain.model.account.AccountId;
import com.victorlevandovski.catalog.domain.model.certificate.Certificate;
import com.victorlevandovski.catalog.domain.model.certificate.CertificateDeliveryOptions;
import com.victorlevandovski.catalog.domain.model.certificate.CertificateId;
import com.victorlevandovski.catalog.domain.model.certificate.CertificateRepository;
import com.victorlevandovski.common.application.command.CommandHandler;
import com.victorlevandovski.common.util.money.Currency;
import com.victorlevandovski.common.util.money.Money;

import java.util.UUID;

public class AddCertificateCommandHandler
        implements CommandHandler<AddCertificateCommand, AddCertificateCommandResult> {

    private CertificateRepository certificateRepository;

    public AddCertificateCommandHandler(CertificateRepository certificateRepository) {
        this();

        this.certificateRepository = certificateRepository;
    }
    public AddCertificateCommandHandler() {
        super();
    }

    @Override
    public void handle(AddCertificateCommand command, AddCertificateCommandResult commandResult) {

        String certificateId = UUID.randomUUID().toString();

        Certificate certificate = new Certificate(
                new AccountId(command.accountId()),
                new CertificateId(certificateId),
                command.title(),
                command.description(),
                new Money(command.priceAmount(), new Currency(command.priceCurrency())),
                new CertificateDeliveryOptions(
                        command.isElectronicDeliveryAvailable(),
                        command.isPostalDeliveryAvailable()
                ),
                command.isAvailableForSale()
        );

        this.certificateRepository().add(certificate);

        commandResult.setCertificateId(certificateId);
    }

    private CertificateRepository certificateRepository() {
        return this.certificateRepository;
    }
}
