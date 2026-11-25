package org.skypro.skyshop.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop.model.search.Searchable;

import java.util.Objects;
import java.util.UUID;

public class Product implements Searchable {
    private final UUID id;
    private final String name;
    private final int price;

    public Product(String name, int price) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Название продукта не может быть пустым");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Цена должна быть больше 0");
        }
        this.id = UUID.randomUUID();
        this.name = name;
        this.price = price;
    }

    @Override
    public UUID getId() { return id; }

    @Override
    public String getName() { return name; }

    public int getPrice() { return price; }

    @JsonIgnore
    public boolean isSpecial() { return false; }

    @Override
    @JsonIgnore
    public String getSearchTerm() { return getName(); }

    @Override
    @JsonIgnore
    public String getContentType() { return "PRODUCT"; }

    @Override
    public String toString() {
        return name + ": " + price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
