package za.co.rhubo.grassroots.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import za.co.rhubo.grassroots.domain.product.Product;
import za.co.rhubo.grassroots.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("")
    public Product createProduct(
            @RequestParam String name, @RequestParam String category,
            @RequestParam double price, @RequestParam String description,
            @RequestParam int providerId){
        return productService.createProduct(name, category, price, description, providerId);
    }

    @GetMapping("")
    public Product getProduct(@RequestParam int productId){
        return productService.getProduct(productId);
    }

    @PutMapping("")
    public Product updateProduct(
            @RequestParam int productId, @RequestParam(required = false) String name,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) double price,
            @RequestParam(required = false) String description){
        return productService.updateProduct(productId, name, category, price, description);
    }

    @DeleteMapping
    public void deleteProduct(@RequestParam int productId){
        productService.deleteProduct(productId);
    }

    @GetMapping("/all")
    public List<Product> getAllProducts(){ return productService.getAllProducts(); }
}
