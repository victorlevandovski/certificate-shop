package com.victorlevandovski.common.util.money;

import java.io.Serializable;
import java.math.BigDecimal;

public class Money implements Serializable {

    private BigDecimal amount;
    private Currency currency;

    public Money (BigDecimal amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public BigDecimal amount() {
        return this.amount;
    }

    public Currency currency() {
        return currency;
    }
}
