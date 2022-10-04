package za.co.rhubo.grassroots.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.co.rhubo.grassroots.domain.product.Product;
import za.co.rhubo.grassroots.domain.user.*;
import za.co.rhubo.grassroots.errorhandling.exceptions.UserException;
import za.co.rhubo.grassroots.persistence.UserRepository;
import za.co.rhubo.grassroots.service.ProductService;
import za.co.rhubo.grassroots.service.UserService;

import java.util.List;
import java.util.Set;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public User createUser(String name, String surname) {

        return userRepository.save(new User(name, surname));
    }

    @Override
    @Transactional
    public User getUser(int userId) {

        return userRepository.findById(userId).orElseThrow(
                () -> new UserException("User with Id " + userId + " not found!"));
    }

    @Override
    public User updateUser(int userId, String name, String surname) {

        User user = getUser(userId);
        if(!name.equals("")) user.setName(name);
        if(!surname.equals("")) user.setSurname(surname);
        return userRepository.save(user);

    }

    @Override
    public void deleteUser(int userId) {
        User user = getUser(userId);
        userRepository.delete(user);
    }

    @Override
    public List<User> getAll(){
        return userRepository.findAll();
    }

    @Override
    public Set<Product> getUserProvidedProducts(int userId) {

        User user = getUser(userId);
        return user.getProvidedProducts();
    }

}
