package org.skypro.skyshop.service;

import org.skypro.skyshop.model.search.SearchResult;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class SearchService {
    private final StorageService storageService;

    public SearchService(StorageService storageService) {
        this.storageService = storageService;
    }

    public Set<SearchResult> search(String pattern) {
        if (pattern == null || pattern.isBlank()) {
            return Collections.emptySet();
        }

        String lowerPattern = pattern.toLowerCase();

        Comparator<SearchResult> comparator = (a, b) -> {
            int lenCmp = Integer.compare(b.getName().length(), a.getName().length());
            if (lenCmp != 0) {
                return lenCmp;
            }
            return a.getName().compareTo(b.getName());
        };

        // Собираем все Searchable из хранилища
        List<Searchable> allItems = new ArrayList<>();
        allItems.addAll(storageService.getProducts().values());
        allItems.addAll(storageService.getArticles().values());

        return allItems.stream()
                .filter(s -> s.getSearchTerm().toLowerCase().contains(lowerPattern))
                .map(SearchResult::fromSearchable)
                .collect(Collectors.toCollection(() -> new TreeSet<>(comparator)));
    }
}