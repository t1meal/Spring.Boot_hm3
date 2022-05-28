package ru.gb.webapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.webapp.model.Product;
import ru.gb.webapp.repositories.ProductRepository;

import java.util.List;
@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts (){
        return productRepository.getAllProducts();
    }
    public Product getProductById (long id){
        return productRepository.getProductById(id);
    }

    public void addProduct (Product product){
        productRepository.addProduct(product);
    }
}
