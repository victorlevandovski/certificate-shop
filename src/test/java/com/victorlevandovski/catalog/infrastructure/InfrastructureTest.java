package com.victorlevandovski.catalog.infrastructure;

import com.victorlevandovski.common.spring.SpringHibernateSessionProvider;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class InfrastructureTest {

    protected ApplicationContext applicationContext;
    protected SpringHibernateSessionProvider sessionProvider;
    private Transaction transaction;

    protected InfrastructureTest() {
        super();
    }

    @BeforeAll
    protected void setUp() {
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        this.sessionProvider = (SpringHibernateSessionProvider) applicationContext.getBean("sessionProvider");
        this.transaction = (this.session().beginTransaction());
    }

    @AfterAll
    protected void tearDown() {
        this.transaction.rollback();
        this.transaction = null;
        this.session().clear();
    }

    protected Session session() {
        return this.sessionProvider.session();
    }
}
