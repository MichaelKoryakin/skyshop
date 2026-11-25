package org.skypro.skyshop.model.article;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop.model.search.Searchable;

import java.util.Objects;
import java.util.UUID;

public class Article implements Searchable {
    private final UUID id;
    private final String title;
    private final String text;

    public Article(String title, String text) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Заголовок статьи не должен быть пустым");
        }
        this.id = UUID.randomUUID();
        this.title = title;
        this.text = text;
    }

    @Override
    public UUID getId() { return id; }

    public String getTitle() { return title; }
    public String getText() { return text; }

    @Override
    public String getName() { return title; }

    @Override
    @JsonIgnore
    public String getSearchTerm() { return title + "\n" + text; }

    @Override
    @JsonIgnore
    public String getContentType() { return "ARTICLE"; }

    @Override
    public String toString() {
        return title + "\n" + text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(id, article.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
