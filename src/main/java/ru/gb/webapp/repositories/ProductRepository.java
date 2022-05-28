package ru.gb.webapp.repositories;

import org.springframework.stereotype.Repository;
import ru.gb.webapp.model.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> productList;

    @PostConstruct
    private void primarySet() {
        this.productList = new ArrayList<>(Arrays.asList(
                new Product(1L, "bread", 50),
                new Product(2L, "milk", 70),
                new Product(3L, "cheese", 350),
                new Product(4L, "meat", 450),
                new Product(5L, "chicken", 220)));
    }

    public Product getProductById(long id) {
        return productList.stream().filter(s -> s.getId().equals(id)).findFirst().get();
//        for (Product element : productList) {
//            if (element.getId() == id) {
//                return element;
//            }
//        }
//        return null;
    }
    public List<Product> getAllProducts() {
        return productList;
    }

    public void addProduct (Product product){
        productList.add(product);
    }
}
