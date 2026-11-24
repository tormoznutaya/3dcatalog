package ru.mirea.kt3.domain;

import java.math.BigDecimal;
import java.util.Objects;
public class Product {
    private final int id;
    private String name;
    private String description;
    private BigDecimal price;

    public Product(int id, String name, String description, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public BigDecimal getPrice() { return price; }

    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setPrice(BigDecimal price) { this.price = price; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product p)) return false;
        return id == p.id;
    }

    @Override
    public int hashCode() { return Objects.hash(id); }
}