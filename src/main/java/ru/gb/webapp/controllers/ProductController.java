package ru.gb.webapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.webapp.model.Product;
import ru.gb.webapp.services.ProductService;

@Controller

public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // GET http://localhost:8080/app/products
    @GetMapping ("/products")
    public String allProductPage (Model model){
        model.addAttribute("products", productService.getAllProducts() );
        return "products";
    }

    // GET http://localhost:8080/app/products/{id}
    @GetMapping("/products/{id}")
    public String showProductByID (Model model,@PathVariable Long id){
        model.addAttribute("product", productService.getProductById(id));
        return "product_info";
    }

    // GET http://localhost:8080/app/products/create
    @GetMapping("/products/create")
    public String createProduct (){
        return "create_product";
    }

    // POST http://localhost:8080/app/products/create
    @PostMapping("/products/create")
    public String saveProduct (@RequestParam Long id,@RequestParam String title,@RequestParam int cost){
        productService.addProduct(new Product(id, title, cost));
        return "redirect:/products";
    }

    //GET http://localhost:8080/app/products/inc
    @GetMapping("/products/inc/{id}")
    public String incCost(@PathVariable Long id){
        productService.productCostInc(id);
        return "redirect:/products";
    }

    //GET http://localhost:8080/app/products/inc
    @GetMapping("/products/dec/{id}")
    public String decCost(@PathVariable Long id){
        productService.productCostDec(id);
        return "redirect:/products";
    }

    //GET http://localhost:8080/app/products/inc
    @GetMapping("/products/delete/{id}")
    public String delete (@PathVariable Long id){
        productService.deleteProduct(id);
        return "redirect:/products";
    }

}
