package ru.mirea.kt3.search;

import ru.mirea.kt3.domain.Model3D;
import ru.mirea.kt3.domain.Tag;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class TagSearchStrategy implements SearchStrategy {
    @Override
    public List<SearchResult> search(List<Model3D> models, List<String> queryTags) {
        Set<String> query = new HashSet<>(queryTags);
        List<SearchResult> results = new ArrayList<>();
        for (Model3D model : models) {
            Set<String> modelTagNames = new HashSet<>();
            for (Tag t : model.getTags()) {
                modelTagNames.add(t.getName());
            }
            int matchCount = 0;
            for (String tag : query) {
                if (modelTagNames.contains(tag)) {
                    matchCount++;
                }
            }
            if (matchCount > 0) {
                results.add(new SearchResult(model, matchCount));
            }
        }
        results.sort(Comparator.comparingInt(SearchResult::getMatches).reversed());
        return results;
    }
}