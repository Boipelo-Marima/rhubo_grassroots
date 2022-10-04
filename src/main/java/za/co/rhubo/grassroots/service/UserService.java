package za.co.rhubo.grassroots.service;

import za.co.rhubo.grassroots.domain.product.Product;
import za.co.rhubo.grassroots.domain.user.User;

import java.util.List;
import java.util.Set;

public interface UserService {

    User createUser(String name, String surname);

    User getUser(int userId);

    User updateUser(int userId, String name, String surname);

    void deleteUser(int userId);

    List<User> getAll();

    Set<Product> getUserProvidedProducts(int userId);

}
