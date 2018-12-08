package com.victorlevandovski.catalog.infrastructure.persistence;

import com.victorlevandovski.catalog.domain.model.account.AccountId;
import com.victorlevandovski.catalog.domain.model.certificate.Certificate;
import com.victorlevandovski.catalog.domain.model.certificate.CertificateId;
import com.victorlevandovski.catalog.domain.model.certificate.CertificateRepository;
import com.victorlevandovski.common.infrastructure.persistence.AbstractHibernateSession;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;

public class HibernateCertificateRepository extends AbstractHibernateSession implements CertificateRepository {

    @Override
    public void add(Certificate certificate) {
        try {
            this.session().save(certificate);
        } catch (ConstraintViolationException e) {
            throw new IllegalStateException("Certificate duplicated");
        }
    }

    @Override
    public void remove(Certificate certificate) {
        this.session().delete(certificate);
    }

    @Override
    public Certificate certificateOfId(AccountId accountId, CertificateId certificateId) {
        Query query = this.session().createQuery(
                "from com.victorlevandovski.catalog.domain.model.certificate.Certificate as _obj_ "
                        + "where _obj_.accountId = ?1 "
                        + "and _obj_.certificateId = ?2");

        query.setParameter(1, accountId);
        query.setParameter(2, certificateId);

        return (Certificate) query.uniqueResult();
    }
}
