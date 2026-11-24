package ru.mirea.kt3.search;

import ru.mirea.kt3.domain.Model3D;
public class SearchResult {
    private final Model3D model;
    private final int matches;

    public SearchResult(Model3D model, int matches) {
        this.model = model;
        this.matches = matches;
    }

    public Model3D getModel() { return model; }
    public int getMatches() { return matches; }
}