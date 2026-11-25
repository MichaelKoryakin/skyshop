package org.skypro.skyshop.controller;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.search.SearchResult;
import org.skypro.skyshop.service.SearchService;
import org.skypro.skyshop.service.StorageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

@RestController
public class ShopController {
    private final SearchService searchService;
    private final StorageService storageService;

    public ShopController(SearchService searchService, StorageService storageService) {
        this.searchService = searchService;
        this.storageService = storageService;
    }

    @GetMapping("/products")
    public Map<UUID, Product> getProducts() {
        return storageService.getProducts();
    }

    @GetMapping("/articles")
    public Map<UUID, Article> getArticles() {
        return storageService.getArticles();
    }

    @GetMapping("/search")
    public Set<SearchResult> search(@RequestParam("pattern") String pattern) {
        return searchService.search(pattern);
    }
}
