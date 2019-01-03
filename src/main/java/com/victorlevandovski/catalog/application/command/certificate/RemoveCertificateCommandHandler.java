package com.victorlevandovski.catalog.application.command.certificate;

import com.victorlevandovski.catalog.domain.model.account.AccountId;
import com.victorlevandovski.catalog.domain.model.certificate.Certificate;
import com.victorlevandovski.catalog.domain.model.certificate.CertificateId;
import com.victorlevandovski.catalog.domain.model.certificate.CertificateRepository;
import com.victorlevandovski.common.application.command.CommandHandler;
import com.victorlevandovski.common.application.command.DefaultCommandResult;

public class RemoveCertificateCommandHandler implements CommandHandler<RemoveCertificateCommand, DefaultCommandResult> {

    private CertificateRepository certificateRepository;

    public RemoveCertificateCommandHandler(CertificateRepository certificateRepository) {
        this();

        this.certificateRepository = certificateRepository;
    }

    public RemoveCertificateCommandHandler() {
        super();
    }

    @Override
    public void handle(RemoveCertificateCommand command, DefaultCommandResult commandResult) {

        Certificate certificate = this.certificateRepository().certificateOfId(
                new AccountId(command.accountId()),
                new CertificateId(command.certificateId())
        );

        this.certificateRepository().remove(certificate);
    }

    private CertificateRepository certificateRepository() {
        return this.certificateRepository;
    }
}
