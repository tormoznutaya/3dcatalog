# Поиск моделей по тегам 
# Сложность O(n*m), где n - модели, m - теги запроса
# Есть вложенный цикл

def search_models(models, search_tags):
    results = []

    # Внешний цикл: проходим по всем моделям
    for model in models:
        match_count = 0
        
        # Вложенный цикл: проверяем каждый тег из запроса
        for tag in search_tags:
            if tag in model.get("tags", []):
                match_count += 1
                
        # Если совпал хотя бы один тег, добавляем в результаты
        if match_count > 0:
            results.append({
                "model": model,
                "matches": match_count
            })

    # Сортируем результаты: больше совпадений — выше в списке
    # Используем встроенную сортировку (Timsort)
    results.sort(key=lambda x: x["matches"], reverse=True)
    
    return results


if __name__ == "__main__":
    catalog = [
        {"id": 1, "name": "Стул", "tags": ["дерево", "кухня", "мебель"]},
        {"id": 2, "name": "Стол", "tags": ["дерево", "офис", "мебель"]},
        {"id": 3, "name": "Лампа", "tags": ["свет", "офис"]}
    ]
    
    query = ["дерево", "офис"]
    found = search_models(catalog, query)
    
    print("Найдено моделей:", len(found))
    for item in found:
        print(f"- {item['model']['name']} (совпадений: {item['matches']})")
