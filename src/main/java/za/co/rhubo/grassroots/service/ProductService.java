package za.co.rhubo.grassroots.service;


import za.co.rhubo.grassroots.domain.product.Product;
import za.co.rhubo.grassroots.domain.user.User;

import java.util.List;

public interface ProductService {

    Product createProduct(String name, String category, double price,
                          String description, int providerId);

    Product getProduct(int productId);

    Product updateProduct(int productId, String name, String category, double price, String description);

    Product addProductCustomer(int productId, User customer);

    void deleteProduct(int productId);

    List<Product> getAllProducts();

    List<Product> findByProductId(String productId);
}
