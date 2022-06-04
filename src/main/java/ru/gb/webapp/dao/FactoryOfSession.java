package ru.gb.webapp.dao;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FactoryOfSession {
    private SessionFactory factory;

    @Autowired
    public FactoryOfSession() {
        factory = new Configuration().
                configure("configs/dao/hibernate.cfg.xml")
                .buildSessionFactory();
    }

    public SessionFactory getFactory() {
        return factory;
    }

    public void setFactory(SessionFactory factory) {
        this.factory = factory;
    }
}
