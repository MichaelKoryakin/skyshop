package org.skypro.skyshop.controller;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.search.Searchable;
import org.skypro.skyshop.service.SearchService;
import org.skypro.skyshop.service.StorageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/shop")
public class ShopController {
    private final SearchService searchService;
    private final StorageService storageService;

    public ShopController(SearchService searchService, StorageService storageService) {
        this.searchService = searchService;
        this.storageService = storageService;
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return storageService.getProducts();
    }

    @GetMapping("/articles")
    public List<Article> getArticles() {
        return storageService.getArticles();
    }

    @GetMapping("/search")
    public Set<Searchable> search(@RequestParam String term) {
        return searchService.search(term);
    }
}
