import json
from algorithms import check_request
from search import search_models
DATA_FILE = "example_data.json"
def load_data(path=DATA_FILE):
    with open(path, "r", encoding="utf-8") as f:
        return json.load(f)
def main():
    data = load_data()
    # Алгоритм 1: проверка комплектности заявки
    req = data["test_request_invalid"]
    ok, missing = check_request(req)
    print("Заявка валидна:", ok)
    if not ok:
        print("Не хватает полей:", missing)
    print()
    # Алгоритм 2: поиск моделей по тегам
    catalog = data["test_catalog"]
    for model in catalog:
        model["tags"] = set(model.get("tags", []))
    query = data["test_query_tags"]
    found = search_models(catalog, query)
    print("Найдено моделей:", len(found))
    for item in found:
        print("- " + item["model"]["название"] + " (совпадений: " + str(item["matches"]) + ")")
if __name__ == "__main__":
    main()
