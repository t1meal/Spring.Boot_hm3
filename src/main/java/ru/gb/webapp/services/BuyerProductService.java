package ru.gb.webapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.webapp.model.Buyer;
import ru.gb.webapp.model.Product;
import ru.gb.webapp.repositories.BuyerDao;
import ru.gb.webapp.repositories.ProductDao;

import java.util.List;

@Service
public class BuyerProductService {
    private BuyerDao buyerDao;
    private ProductDao productDao;

    @Autowired
    public void setBuyerDao(BuyerDao buyerDao) {
        this.buyerDao = buyerDao;
    }
    @Autowired
    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    public List<Product> findProductsOfBuyer (Long id){
        return buyerDao.getBuyersProducts(id);
    }
    public List<Buyer> findBuyersOfProduct (Long id){
        return productDao.getProductBuyers(id);
    }

    public BuyerDao getBuyerDao() {
        return buyerDao;
    }
    public ProductDao getProductDao() {
        return productDao;
    }
}
