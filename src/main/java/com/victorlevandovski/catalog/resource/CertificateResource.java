package com.victorlevandovski.catalog.resource;

import com.victorlevandovski.catalog.CatalogRegistry;
import com.victorlevandovski.catalog.application.command.certificate.AddCertificateCommand;
import com.victorlevandovski.catalog.application.command.certificate.AddCertificateCommandResult;
import com.victorlevandovski.catalog.application.command.certificate.RemoveCertificateCommand;
import com.victorlevandovski.catalog.application.query.certificate.CertificateData;
import com.victorlevandovski.catalog.domain.model.account.AccountId;
import com.victorlevandovski.catalog.domain.model.certificate.Certificate;
import com.victorlevandovski.catalog.domain.model.certificate.CertificateId;
import com.victorlevandovski.catalog.domain.model.certificate.CertificateRepository;
import com.victorlevandovski.common.resource.AbstractResource;
import com.victorlevandovski.common.serializer.ObjectSerializer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/catalog/accounts/{accountId}/certificates")
public class CertificateResource extends AbstractResource {

    @PostMapping
    public String addCertificate(
            @PathVariable("accountId") String accountId,
            @RequestParam("title") String title,
            @RequestParam(value = "description", required = false) String description,
            @RequestParam("priceAmount") BigDecimal priceAmount,
            @RequestParam("priceCurrency") String priceCurrency,
            @RequestParam("electronicDeliveryAvailable") boolean electronicDeliveryAvailable,
            @RequestParam("postalDeliveryAvailable") boolean postalDeliveryAvailable,
            @RequestParam("availableForSale") boolean availableForSale) {

        AddCertificateCommand command = new AddCertificateCommand(
                accountId,
                title,
                description,
                priceAmount,
                priceCurrency,
                electronicDeliveryAvailable,
                postalDeliveryAvailable,
                availableForSale);

        AddCertificateCommandResult result = new AddCertificateCommandResult();

        this.commandBus().handle(command, result);

        Certificate certificate = this.certificateRepository().certificateOfId(
                new AccountId(accountId),
                new CertificateId(result.certificateId()));

        return ObjectSerializer.instance().serialize(CertificateData.fromCertificate(certificate));
    }

    @GetMapping("{certificateId}")
    public String certificate(
            @PathVariable("accountId") String accountId,
            @PathVariable("certificateId") String certificateId) {

        Certificate certificate = this.certificateRepository().certificateOfId(
                new AccountId(accountId),
                new CertificateId(certificateId));

        return ObjectSerializer.instance().serialize(CertificateData.fromCertificate(certificate));
    }

    @DeleteMapping("{certificateId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeCertificate(
            @PathVariable("accountId") String accountId,
            @PathVariable("certificateId") String certificateId) {

        RemoveCertificateCommand command = new RemoveCertificateCommand(accountId, certificateId);
        this.commandBus().handle(command, null);
    }

    private CertificateRepository certificateRepository() {
        return CatalogRegistry.certificateRepository();
    }
}
