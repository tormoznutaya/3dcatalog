# Проверка комплектности заявки (Алгоритм 1)
# Сложность O(n), где n - количество полей

def check_request(req):
    required = ["title", "description", "model_file", "price"]
    missing = []

    for field in required:
        if field not in req or not req[field]:
            missing.append(field)

    if missing:
        return False, missing
    return True, []


if __name__ == "__main__":
    # Тестовые данные (не хватает цены)
    test_req = {
        "title": "Стол",
        "description": "Круглый стол",
        "model_file": "table.gltf"
    }
    
    ok, errs = check_request(test_req)
    print("Заявка валидна:", ok)
    if not ok:
        print("Не хватает полей:", errs)
