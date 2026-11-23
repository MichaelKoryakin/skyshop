package org.skypro.skyshop.model.product;

import org.skypro.skyshop.model.search.Searchable;
import java.util.Objects;

public class Product implements Searchable { // <-- Добавили implements
    private final String name;
    private final int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public int getPrice() { return price; }
    public boolean isSpecial() { return false; }

    @Override
    public String getSearchTerm() {
        return getName(); // Поиск по имени продукта
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }

    @Override
    public String toString() {
        return name + ": " + price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
