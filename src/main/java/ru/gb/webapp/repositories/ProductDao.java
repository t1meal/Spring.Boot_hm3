package ru.gb.webapp.repositories;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.webapp.dao.FactoryOfSession;
import ru.gb.webapp.dao.PrepareDataDB;
import ru.gb.webapp.model.Product;

import java.util.List;

@Service
public class ProductDao {
    private FactoryOfSession factoryOfSession;
    private PrepareDataDB prepareDataDB;

    @Autowired
    private void setPrimary(FactoryOfSession factoryOfSession, PrepareDataDB prepareDataDB) {
        this.factoryOfSession = factoryOfSession;
        this.prepareDataDB = prepareDataDB;
    }

    @Autowired
    private void refreshBD (){
        prepareDataDB.refresh();
    }

    public void save (Product product) {
        try (Session session = factoryOfSession.getFactory().getCurrentSession()) {
            session.beginTransaction();
            session.save(product);
            session.getTransaction().commit();
        }
    }

    public void deleteById (Long id) {
        try (Session session = factoryOfSession.getFactory().getCurrentSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.delete(product);
            session.getTransaction().commit();
        }
    }

    public Product findById(Long id) {
        Product product;
        try (Session session = factoryOfSession.getFactory().getCurrentSession()) {
            session.beginTransaction();
            product = session.get(Product.class, id);
            session.getTransaction().commit();
        }
        return product;
    }
    public List<Product> findAll (){
        List<Product> productList;
        try (Session session = factoryOfSession.getFactory().getCurrentSession()) {
            session.beginTransaction();
            productList = session.createQuery("from Product").getResultList();
            session.getTransaction().commit();
        }
        return productList;
    }

    public void costInc (Long id){
        try (Session session = factoryOfSession.getFactory().getCurrentSession()){
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            product.incCost();
            session.getTransaction().commit();
        }
    }
    public void costDec (Long id){
        try (Session session = factoryOfSession.getFactory().getCurrentSession()){
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            product.decCost();
            session.getTransaction().commit();
        }
    }
}
