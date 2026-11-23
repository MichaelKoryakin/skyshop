package org.skypro.skyshop.service;

import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class SearchService {
    private final Set<Searchable> items = new HashSet<>();

    public void add(Searchable s) {
        items.add(s);
    }

    public Set<Searchable> search(String searchTerm) {
        if (searchTerm == null || searchTerm.isBlank()) {
            return Collections.emptySet();
        }

        Comparator<Searchable> comparator = (a, b) -> {
            int lenCmp = Integer.compare(b.getName().length(), a.getName().length());
            if (lenCmp != 0) {
                return lenCmp;
            }
            return a.getName().compareTo(b.getName());
        };

        return items.stream()
                .filter(s -> s.getSearchTerm().toLowerCase().contains(searchTerm.toLowerCase()))
                .collect(Collectors.toCollection(() -> new TreeSet<>(comparator)));
    }
}