package za.co.rhubo.grassroots.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import za.co.rhubo.grassroots.domain.product.Product;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity

@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private String surname;

    @OneToMany(mappedBy = "provider")
    @JsonIgnore
    private Set<Product> providedProducts = new HashSet<>();

    @ManyToMany(mappedBy = "consumers")
    @JsonIgnore
    private Set<Product> consumedProducts = new HashSet<>();

    public User() {
    }

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Set<Product> getProvidedProducts() {
        return providedProducts;
    }

    public void setProvidedProducts(Set<Product> providedProducts) {
        this.providedProducts = providedProducts;
    }

    public Set<Product> getConsumedProducts() {
        return consumedProducts;
    }

    public void setConsumedProducts(Set<Product> consumedProducts) {
        this.consumedProducts = consumedProducts;
    }
}
