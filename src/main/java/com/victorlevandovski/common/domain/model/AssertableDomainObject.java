package com.victorlevandovski.common.domain.model;

public abstract class AssertableDomainObject {

    protected void assertNotNull(Object object, String message) {
        if (object == null) {
            throw new IllegalArgumentException(message);
        }
    }

    protected void assertNotEmpty(String string, String message) {
        if (string == null || string.trim().isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }

    protected void assertLength(String string, int max, String message) {
        if (string.trim().length() > max) {
            throw new IllegalArgumentException(message);
        }
    }

    protected void assertLength(String string, int min, int max, String message) {
        int length = string.trim().length();
        if (length < min || length > max) {
            throw new IllegalArgumentException(message);
        }
    }

    protected void assertRange(int number, int min, int max, String message) {
        if (number < min || number > max) {
            throw new IllegalArgumentException(message);
        }
    }

    protected void assertRange(long number, long min, long max, String message) {
        if (number < min || number > max) {
            throw new IllegalArgumentException(message);
        }
    }
}
