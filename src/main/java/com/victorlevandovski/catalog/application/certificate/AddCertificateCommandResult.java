package com.victorlevandovski.catalog.application.certificate;

import com.victorlevandovski.common.application.command.CommandResult;

public class AddCertificateCommandResult implements CommandResult {

    private String certificateId;

    public AddCertificateCommandResult() {
        super();
    }

    public String certificateId() {
        return this.certificateId;
    }

    public void setCertificateId(String certificateId) {
        this.certificateId = certificateId;
    }
}
