package za.co.rhubo.grassroots.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.co.rhubo.grassroots.domain.product.Product;
import za.co.rhubo.grassroots.domain.user.User;
import za.co.rhubo.grassroots.errorhandling.exceptions.UserException;
import za.co.rhubo.grassroots.persistence.ProductRepository;
import za.co.rhubo.grassroots.service.ProductService;
import za.co.rhubo.grassroots.service.UserService;

import java.util.List;

@Service("ProductService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserService userService;

    @Override
    @Transactional
    public Product createProduct(String name, String category, double price,
                                 String description, int providerId) {
        User provider = userService.getUser(providerId);

        return productRepository.save(
                new Product(name, category, price, description, provider)
        );
    }

    @Override
    @Transactional
    public Product getProduct(int productId) {
        return productRepository.findById(productId).orElseThrow(
                () -> new UserException("Product with Id " + productId + " not found!")
        );
    }

    @Override
    @Transactional
    public Product updateProduct(int productId, String name, String category, double price, String description) {
        Product product = getProduct(productId);

        if(!name.equals("")) product.setName(name);
        if(!category.equals("")) product.setCategory(category);
        if(price == 0.0D) product.setPrice(price);
        if(!description.equals("")) product.setDescription(description);

        return productRepository.save(product);
    }

    @Override
    @Transactional
    public Product addProductCustomer(int id, User customer){
        Product product = getProduct(id);
        product.addConsumer(customer);
        productRepository.save(product);
        return product;
    }

    @Override
    @Transactional
    public void deleteProduct(int productId) {
        Product product = getProduct(productId);
        productRepository.delete(product);
    }

    @Override
    @Transactional
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    @Transactional
    public List<Product> findByProductId(String productId) {
        return productRepository.findByProductId(productId);
    }

}
