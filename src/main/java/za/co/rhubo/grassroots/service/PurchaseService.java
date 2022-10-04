package za.co.rhubo.grassroots.service;

import org.springframework.stereotype.Service;

public interface PurchaseService {

    void purchaseProduct(int userId, String productId);
}
