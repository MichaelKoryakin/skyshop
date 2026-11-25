package org.skypro.skyshop.service;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class StorageService {
    private final Map<UUID, Product> products;
    private final Map<UUID, Article> articles;

    public StorageService() {
        this.products = new HashMap<>();
        this.articles = new HashMap<>();
        initTestData();
    }

    private void initTestData() {
        Product p1 = new SimpleProduct("Тетрадь 48л", 50);
        Product p2 = new FixPriceProduct("Ручка синяя");
        Product p3 = new DiscountedProduct("Книга по Java", 500, 20);
        products.put(p1.getId(), p1);
        products.put(p2.getId(), p2);
        products.put(p3.getId(), p3);

        Article a1 = new Article("back-to-school", "Что купить к школе?");
        Article a2 = new Article("office-life", "Как выбрать канцтовары для офиса?");
        articles.put(a1.getId(), a1);
        articles.put(a2.getId(), a2);
    }

    public Map<UUID, Product> getProducts() {
        return products;
    }

    public Map<UUID, Article> getArticles() {
        return articles;
    }
}