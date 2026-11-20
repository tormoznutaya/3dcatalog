# Сложность по времени: O(n*m + n*log n), где n — число моделей в каталоге, m — число тегов в поисковом запросе, n*m  — вложенный цикл (модели x теги запроса), каждая проверка O(1), n*log n — сортировка результатов (Timsort).
# Сложность по памяти: O(n) — список результатов.
def search_models(models, search_tags):
    results = []
    for model in models:
        model_tags = model.get("tags", set())
        if not isinstance(model_tags, set):
            model_tags = set(model_tags)
        match_count = 0
        for tag in search_tags:
            if tag in model_tags:   # O(1), потому что model_tags — множество
                match_count += 1
        if match_count > 0:
            results.append({"model": model, "matches": match_count})
    results.sort(key=lambda x: x["matches"], reverse=True)
    return results
