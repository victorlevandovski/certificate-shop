package com.victorlevandovski.common.infrastructure.persistence;

import com.victorlevandovski.common.spring.SpringHibernateSessionProvider;
import org.hibernate.Session;

public abstract class AbstractHibernateSession {

    private Session session;
    private SpringHibernateSessionProvider sessionProvider;

    protected AbstractHibernateSession() {
        super();
    }

    protected AbstractHibernateSession(Session session) {
        this();

        this.setSession(session);
    }

//    protected AbstractHibernateSession(SpringHibernateSessionProvider sessionProvider) {
//        this();
//
//        this.setSessionProvider(sessionProvider);
//    }

    protected Session session() {
        if (this.session != null) {
            return this.session;
        }

        if (this.sessionProvider == null) {
            throw new IllegalStateException("Requires either Session or HibernateSessionProvider");
        }

        return this.sessionProvider.session();
    }

    protected void setSession(Session session) {
        this.session = session;
    }

    public void setSessionProvider(SpringHibernateSessionProvider sessionProvider) {
        this.sessionProvider = sessionProvider;
    }
}
