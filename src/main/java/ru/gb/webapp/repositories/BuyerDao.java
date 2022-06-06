package ru.gb.webapp.repositories;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.gb.webapp.model.Buyer;
import ru.gb.webapp.model.Product;
import ru.gb.webapp.services.db.SessionService;

import java.util.List;

@Component
public class BuyerDao implements MainDao<Buyer> {

    SessionService factory;

    @Autowired
    public void setFactory(SessionService factory) {
        this.factory = factory;
    }

    @Override
    public void save(Buyer buyer) {
        try (Session session = factory.getFactory().getCurrentSession()) {
            session.beginTransaction();
            session.save(buyer);
            session.getTransaction().commit();
        }
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = factory.getFactory().getCurrentSession()) {
            session.beginTransaction();
            Buyer buyer = session.get(Buyer.class, id);
            session.delete(buyer);
            session.getTransaction().commit();
        }
    }

    @Override
    public Buyer findById(Long id) {
        Buyer buyer;
        try (Session session = factory.getFactory().getCurrentSession()) {
            session.beginTransaction();
            buyer = session.get(Buyer.class, id);
            session.getTransaction().commit();
        }
        return buyer;
    }
    @Override
    public List<Buyer> findAll() {
        List<Buyer> buyers;
        try (Session session = factory.getFactory().getCurrentSession()) {
            session.beginTransaction();
            buyers = session.createQuery("from Buyer").getResultList();
            session.getTransaction().commit();
        }
        return buyers;
    }
    public List<Product> getBuyersProducts(Long id) {
        List<Product> buyerProducts;
        try (Session session = factory.getFactory().getCurrentSession()) {
            session.beginTransaction();
            Buyer buyer = session.get(Buyer.class, id);
            System.out.println(buyer);
            System.out.println(buyer.getProducts());
            buyerProducts = buyer.getProducts();
            session.getTransaction().commit();
        }
        return buyerProducts;
    }
}
