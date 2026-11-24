package ru.mirea.kt3.search;
import ru.mirea.kt3.domain.Model3D;
import java.util.List;
public interface SearchStrategy {
    List<SearchResult> search(List<Model3D> models, List<String> queryTags);
}