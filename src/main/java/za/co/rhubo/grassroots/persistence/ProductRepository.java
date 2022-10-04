package za.co.rhubo.grassroots.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.rhubo.grassroots.domain.product.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    public List<Product> findByProductId(String productId);
}
