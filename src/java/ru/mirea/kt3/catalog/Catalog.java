package ru.mirea.kt3.catalog;

import ru.mirea.kt3.domain.Model3D;
import ru.mirea.kt3.domain.Product;
import ru.mirea.kt3.search.SearchResult;
import ru.mirea.kt3.search.SearchStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
public class Catalog {
    private final List<Model3D> models = new ArrayList<>();
    private final Map<Integer, Product> productsById = new HashMap<>();
    private final Map<Integer, Model3D> modelsById = new HashMap<>();

    public void addProduct(Product product) {
        productsById.put(product.getId(), product);
    }

    public void addModel(Model3D model) {
        models.add(model);
        modelsById.put(model.getId(), model);
    }

    public List<Model3D> getModels() {
        return List.copyOf(models);
    }

    public Optional<Model3D> findModelById(int id) {
        return Optional.ofNullable(modelsById.get(id));
    }

    public Optional<Product> findProductById(int id) {
        return Optional.ofNullable(productsById.get(id));
    }

    public List<SearchResult> search(List<String> tags, SearchStrategy strategy) {
        return strategy.search(models, tags);
    }
    public String modelName(Model3D model) {
        Product p = productsById.get(model.getProductId());
        return p != null ? p.getName() : "(без названия)";
    }
}