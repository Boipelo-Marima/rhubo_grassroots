package za.co.rhubo.grassroots.domain.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import za.co.rhubo.grassroots.domain.user.User;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private String category;

    @Column
    private double price;

    @Column
    private String description;

    @Column
    private final String productId;

    { productId = UUID.randomUUID().toString().substring(0, 5); }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "provider_id", referencedColumnName = "id")
    private User provider;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "product_customers",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id")
    )
    private Set<User> consumers = new HashSet<>();

    public Product() {
    }

    public Product(String name, String category, double price,
                   String description, User provider) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.description = description;
        this.provider = provider;
    }

    public User getProvider() {
        return provider;
    }

    public void setProvider(User provider) {
        this.provider = provider;
    }

    public Set<User> getConsumers() {
        return consumers;
    }

    public void setConsumers(Set<User> consumers) {
        this.consumers = consumers;
    }

    public void addConsumer(User user){
        this.consumers.add(user);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductID() {
        return productId;
    }

    @Override
    public String toString() {
        return "ProvidedProduct{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", productID=" + productId +
                ", provider=" + provider +
                ", consumers=" + consumers +
                '}';
    }
}
