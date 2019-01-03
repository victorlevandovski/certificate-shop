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
@RequestMapping("/catalog")
public class CertificateResource extends AbstractResource {

    @PostMapping("certificates")
    public String addCertificate(
            @RequestParam("title") String title,
            @RequestParam(value = "description", required = false) String description,
            @RequestParam("price_amount") BigDecimal priceAmount,
            @RequestParam("price_currency") String priceCurrency,
            @RequestParam("electronic_delivery_available") boolean electronicDeliveryAvailable,
            @RequestParam("postal_delivery_available") boolean postalDeliveryAvailable,
            @RequestParam("available_for_sale") boolean availableForSale) {

        String accountId = "account-1"; // Should be loaded from session

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

    @GetMapping("certificates/{certificate_id}")
    public String certificate(@PathVariable("certificate_id") String certificateId) {

        String accountId = "account-1"; // Should be loaded from session

        Certificate certificate = this.certificateRepository().certificateOfId(
                new AccountId(accountId),
                new CertificateId(certificateId));

        return ObjectSerializer.instance().serialize(CertificateData.fromCertificate(certificate));
    }

    @DeleteMapping("certificates/{certificate_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeCertificate(@PathVariable("certificate_id") String certificateId) {

        String accountId = "account-1"; // Should be loaded from session

        RemoveCertificateCommand command = new RemoveCertificateCommand(accountId, certificateId);
        this.commandBus().handle(command, null);
    }

    private CertificateRepository certificateRepository() {
        return CatalogRegistry.certificateRepository();
    }
}
