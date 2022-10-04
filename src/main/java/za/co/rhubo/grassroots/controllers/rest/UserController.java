package za.co.rhubo.grassroots.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.co.rhubo.grassroots.domain.product.Product;
import za.co.rhubo.grassroots.domain.user.User;
import za.co.rhubo.grassroots.service.UserService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("")
    public User createUser(
            @RequestParam() String name,
            @RequestParam() String surname) {

        return userService.createUser(name, surname);
    }

    @GetMapping("")
    public User getUser(@RequestParam int userId) {
        return userService.getUser(userId);
    }

    @PutMapping("")
    public User updateUser(
            @RequestParam int userId,
            @RequestParam String name, @RequestParam String surname) {
        return userService.updateUser(userId, name, surname);
    }

    @DeleteMapping("")
    public void deleteUser(@RequestParam int userId) {
        userService.deleteUser(userId);
    }

    @GetMapping("/all")
    public List<User> getAllUsers(){
        return userService.getAll();
    }

    @GetMapping("/products/provided")
    public Set<Product> getUserProvidedProducts(@RequestParam int userId){
        return userService.getUserProvidedProducts(userId);
    }

}
