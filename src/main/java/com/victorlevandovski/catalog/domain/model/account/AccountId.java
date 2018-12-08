package com.victorlevandovski.catalog.domain.model.account;

import com.victorlevandovski.common.domain.model.Identity;

public class AccountId extends Identity {

    public AccountId(String id) {
        super(id);
    }

    protected AccountId() {
        super();
    }

    @Override
    protected int hashOddValue() {
        return 53971;
    }

    @Override
    protected int hashPrimeValue() {
        return 37;
    }
}
