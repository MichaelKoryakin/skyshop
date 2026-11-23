package org.skypro.skyshop.model.product;

import org.skypro.skyshop.model.search.Searchable;

public class SimpleProduct extends Product implements Searchable {
    public SimpleProduct(String name, int price) {
        super(name, price);
    }

    @Override
    public String getSearchTerm() {
        return getName();
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }

    @Override
    public String getName() {
        return super.getName();
    }
}
