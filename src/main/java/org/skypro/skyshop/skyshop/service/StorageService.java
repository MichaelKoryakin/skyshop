package org.skypro.skyshop.service;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StorageService {
    private final List<Product> products = new ArrayList<>();
    private final List<Article> articles = new ArrayList<>();
    private final SearchService searchService;

    public StorageService(SearchService searchService) {
        this.searchService = searchService;

        // Добавляем тестовые продукты
        products.add(new SimpleProduct("Тетрадь 48л", 50));
        products.add(new FixPriceProduct("Ручка синяя"));
        products.add(new DiscountedProduct("Книга по Java", 500, 20));

        // Добавляем тестовые статьи
        articles.add(new Article("back-to-school", "Что купить к школе?"));
        articles.add(new Article("office-life", "Как выбрать канцтовары для офиса?"));

        // Регистрируем всё в поиске
        products.forEach(searchService::add);
        articles.forEach(searchService::add);
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Article> getArticles() {
        return articles;
    }
}