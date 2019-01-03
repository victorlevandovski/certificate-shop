package com.victorlevandovski.catalog;

import com.victorlevandovski.catalog.application.command.certificate.AddCertificateCommand;
import com.victorlevandovski.catalog.application.command.certificate.AddCertificateCommandHandler;
import com.victorlevandovski.catalog.application.command.certificate.RemoveCertificateCommand;
import com.victorlevandovski.catalog.application.command.certificate.RemoveCertificateCommandHandler;
import com.victorlevandovski.catalog.domain.model.certificate.CertificateRepository;
import com.victorlevandovski.common.application.command.CommandBus;
import com.victorlevandovski.common.application.command.SpringCommandBus;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class CatalogRegistry implements ApplicationContextAware {

    private static ApplicationContext applicationContext;
    private static CommandBus commandBus;

    public static CertificateRepository certificateRepository() {
        return (CertificateRepository) CatalogRegistry.applicationContext.getBean("certificateRepository");
    }

    public static CommandBus commandBus() {
        if (CatalogRegistry.commandBus == null) {
            CommandBus commandBus = new SpringCommandBus();

            commandBus.subscribe(
                    AddCertificateCommand.class,
                    new AddCertificateCommandHandler(CatalogRegistry.certificateRepository()));

            commandBus.subscribe(
                    RemoveCertificateCommand.class,
                    new RemoveCertificateCommandHandler(CatalogRegistry.certificateRepository()));

            CatalogRegistry.commandBus = commandBus;
        }

        return CatalogRegistry.commandBus;
    }

    @Override
    public synchronized void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (CatalogRegistry.applicationContext == null) {
            CatalogRegistry.applicationContext = applicationContext;
        }
    }
}
