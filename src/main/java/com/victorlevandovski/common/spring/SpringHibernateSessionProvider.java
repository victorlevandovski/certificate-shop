package com.victorlevandovski.common.spring;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class SpringHibernateSessionProvider {

    private static final ThreadLocal<Session> sessionHolder = new ThreadLocal<>();

    private SessionFactory sessionFactory;

    public SpringHibernateSessionProvider(SessionFactory sessionFactory) {
        this();

        this.setSessionFactory(sessionFactory);
    }

    public SpringHibernateSessionProvider() {
        super();
    }

    public Session session() {
        Session threadBoundSession = sessionHolder.get();

        if (threadBoundSession == null) {
            threadBoundSession = this.sessionFactory.openSession();
            sessionHolder.set(threadBoundSession);
        }

        return threadBoundSession;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
