package com.victorlevandovski;

import com.victorlevandovski.catalog.CatalogRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        CatalogRegistry catalogRegistry = new CatalogRegistry();
        catalogRegistry.setApplicationContext(ctx);
    }
}
