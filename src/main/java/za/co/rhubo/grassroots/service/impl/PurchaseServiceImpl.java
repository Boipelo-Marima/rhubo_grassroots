package za.co.rhubo.grassroots.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.rhubo.grassroots.domain.product.Product;
import za.co.rhubo.grassroots.domain.user.User;
import za.co.rhubo.grassroots.errorhandling.exceptions.ProductException;
import za.co.rhubo.grassroots.service.ProductService;
import za.co.rhubo.grassroots.service.PurchaseService;
import za.co.rhubo.grassroots.service.UserService;

@Service("purchaseService")
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    ProductService productService;

    @Autowired
    UserService userService;

    @Override
    public void purchaseProduct(int userId, String productId) {
        Product product = productService.findByProductId(productId).get(0);
        User user = userService.getUser(userId);

        if(user.getId() != product.getProvider().getId())
            productService.addProductCustomer(product.getId(), user);
        else
            throw new ProductException("User cannot buy product they provide");

    }
}
