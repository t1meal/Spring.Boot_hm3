package ru.gb.webapp.repositories;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.webapp.model.Buyer;
import ru.gb.webapp.services.db.SessionService;
import ru.gb.webapp.model.Product;

import java.util.List;

@Service
public class ProductDao implements MainDao<Product> {
    private SessionService factory;

    @Autowired
    private void setFactory(SessionService factory) {
        this.factory = factory;
    }
    @Override
    public void save(Product product) {
        try (Session session = factory.getFactory().getCurrentSession()) {
            session.beginTransaction();
            session.save(product);
            session.getTransaction().commit();
        }
    }
    @Override
    public void deleteById(Long id) {
        try (Session session = factory.getFactory().getCurrentSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.delete(product);
            session.getTransaction().commit();
        }
    }

    @Override
    public Product findById(Long id) {
        Product product;
        try (Session session = factory.getFactory().getCurrentSession()) {
            session.beginTransaction();
            product = session.get(Product.class, id);
            session.getTransaction().commit();
        }
        return product;
    }

    @Override
    public List<Product> findAll() {
        List<Product> productList;
        try (Session session = factory.getFactory().getCurrentSession()) {
            session.beginTransaction();
            productList = session.createQuery("from Product").getResultList();
            session.getTransaction().commit();
        }
        return productList;
    }

    public void costInc(Long id) {
        try (Session session = factory.getFactory().getCurrentSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            product.incCost();
            session.getTransaction().commit();
        }
    }
    public void costDec(Long id) {
        try (Session session = factory.getFactory().getCurrentSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            product.decCost();
            session.getTransaction().commit();
        }
    }
    public List<Buyer> getProductBuyers(Long id) {
        List<Buyer> productBuyers;
        try (Session session = factory.getFactory().getCurrentSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            System.out.println(product);
            System.out.println(product.getBuyers());
            productBuyers = product.getBuyers();
            session.getTransaction().commit();
        }
        return productBuyers;
    }
}
