package com.victorlevandovski.common.util.money;

public class Currency {

    private String code;

    public static Currency EUR = new Currency("EUR");

    public Currency(String code) {
        this();

        if (code == null) {
            throw new IllegalArgumentException("Currency code cannot be null");
        }

        this.code = code;
    }

    public String code() {
        return this.code;
    }

    protected Currency() {
        super();
    }
}
