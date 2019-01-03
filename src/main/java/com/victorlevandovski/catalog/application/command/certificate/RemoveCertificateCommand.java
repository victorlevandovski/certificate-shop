package com.victorlevandovski.catalog.application.command.certificate;

import com.victorlevandovski.common.application.command.Command;

public class RemoveCertificateCommand implements Command {

    private String accountId;
    private String certificateId;

    public RemoveCertificateCommand(
            String accountId,
            String certificateId
    ) {
        this.accountId = accountId;
        this.certificateId = certificateId;
    }

    public String accountId() {
        return this.accountId;
    }

    public String certificateId() {
        return this.certificateId;
    }
}
