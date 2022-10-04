package za.co.rhubo.grassroots.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import za.co.rhubo.grassroots.service.PurchaseService;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    PurchaseService purchaseService;

    @PostMapping("")
    public void buyProduct(@RequestParam int userId,
                           @RequestParam String productId){
        purchaseService.purchaseProduct(userId, productId);
    }
}
