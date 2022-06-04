package ru.gb.webapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.webapp.model.Product;
import ru.gb.webapp.repositories.ProductDao;

import java.util.List;
@Service
public class ProductService {
    private ProductDao productDao;

    @Autowired
    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    public List<Product> getAllProducts (){
        return productDao.findAll();
    }
    public Product getProductById (long id){
        return productDao.findById(id);
    }

    public void addProduct (Product product){
        productDao.save(product);
    }

    public void productCostInc(Long id){
        productDao.costInc(id);
    }
    public void productCostDec(Long id){
        productDao.costDec(id);
    }

    public void deleteProduct (Long id){
        productDao.deleteById(id);
    }
}
