package com.victorlevandovski.common.resource;

import com.victorlevandovski.catalog.CatalogRegistry;
import com.victorlevandovski.common.application.command.CommandBus;

public abstract class AbstractResource {

    protected CommandBus commandBus() {
        return CatalogRegistry.commandBus();
    }
}
