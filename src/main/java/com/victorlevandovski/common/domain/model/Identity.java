package com.victorlevandovski.common.domain.model;

public abstract class Identity extends AssertableDomainObject {

    protected String id;

    protected Identity(String id) {
        super();

        this.setId(id);
    }

    public String id() {
        return this.id;
    }

    protected void validateId(String id) {
        //
    }

    protected void setId(String id) {
        this.assertNotEmpty(id, "Identity must not be empty");
        this.assertLength(id, 36, "Identity must be 36 characters long");

        this.validateId(id);

        this.id = id;
    }

    protected abstract int hashOddValue();

    protected abstract int hashPrimeValue();

    @Override
    public int hashCode() {
        return this.hashOddValue() * this.hashPrimeValue() + this.id().hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (object != null && this.getClass() == object.getClass()) {
            Identity identity = (Identity) object;
            return this.id().equals(identity.id());
        }

        return false;
    }
}
