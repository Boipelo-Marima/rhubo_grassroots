package za.co.rhubo.grassroots.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.rhubo.grassroots.domain.product.Product;

public interface PurchaseRepository extends JpaRepository<Product, Integer> {
}
