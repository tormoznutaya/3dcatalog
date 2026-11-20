# Проверка комплектности заявки (Алгоритм 1)
# Проверка формата 3D-модели
# Сложность check_request: O(n), где n — число обязательных полей заявки.
#  Один цикл for, время растёт линейно. Память — O(1).
REQUIRED_REQUEST_FIELDS = ["id_товароведа", "id_модели", "дата"]
ALLOWED_MODEL_FORMATS = {"glTF", "GLB"}
MAX_MODEL_SIZE_MB = 50
def check_request(req):
    """Проверяет наличие обязательных полей заявки.
    Возвращает (True, []) если все поля заполнены,
    иначе (False, [список отсутствующих полей])."""
    missing = []
    for field in REQUIRED_REQUEST_FIELDS:
        value = req.get(field)
        if value is None or value == "":
            missing.append(field)
    if missing:
        return False, missing
    return True, []
def validate_model_format(model):
    """Проверяет, что файл 3D-модели в допустимом формате и указан путь.
    Возвращает (True, []) если всё корректно,
    иначе (False, [список ошибок])."""
    errors = []
    fmt = model.get("формат")
    if fmt not in ALLOWED_MODEL_FORMATS:
        errors.append("недопустимый формат: " + str(fmt))
    if not model.get("путь_к_файлу"):
        errors.append("не указан путь к файлу")
    return (True, []) if not errors else (False, errors)
if __name__ == "__main__":
    demo_req = {"id_заявки": 1, "id_товароведа": 5}
    ok, errs = check_request(demo_req)
    print("Заявка валидна:", ok)
    if not ok:
        print("Не хватает полей:", errs)
