# ООП-реализация на Java (КТ3)

## Версия JDK и инструмент сборки
- **JDK**: OpenJDK 21 (LTS), сборка `javac` из JDK 21 (Temurin 21.0.5+11 или любая
  другая совместимая сборка JDK 21). Подойдёт и более ранняя LTS — Java 17.
- **Сборка**: `javac` без Maven/Gradle. Сторонних библиотек нет — только
  стандартная библиотека Java (`java.base`).

## Структура исходников

Исходники лежат в папке `src/java/` корня репозитория (структура папок в
архиве соответствует требованиям памятки КТ3 — `src/java/` обязательна).
Каталог пакетов следует конвенции МРЭА: путь к файлу совпадает с именем
пакета, как требует Java-конвенция «один публичный класс — один файл,
папки зеркально повторяют пакет».

    src/java/
        README.md                как собрать и запустить (этот файл)
        ru/mirea/kt3/
            Main.java            точка входа (package ru.mirea.kt3)
            catalog/
                Catalog.java     package ru.mirea.kt3.catalog
            domain/
                Product.java     package ru.mirea.kt3.domain
                Tag.java
                Model3D.java
                Request.java
                User.java        abstract
            users/
                Merchandiser.java    package ru.mirea.kt3.users  (extends User)
                Designer3D.java
                ContentManager.java
            validation/
                Rule.java            interface Rule<T>
                ValidationResult.java
                CompletenessRule.java   Алгоритм 1
                FormatRule.java
            search/
                SearchStrategy.java  interface
                SearchResult.java
                TagSearchStrategy.java   Алгоритм 2

Всего 17 файлов `.java`, ~280 строк. Папки `catalog`, `domain`, `users`,
`validation`, `search` соответствуют одноимённым подпакетам `ru.mirea.kt3.*`.

## Сборка и запуск
Из корня репозитория. Путь к файлам совпадает с именем пакета, поэтому
работает и стандартный glob, и `find`:

    javac -encoding UTF-8 -d out $(find src/java -name '*.java')
    java -cp out ru.mirea.kt3.Main

Альтернатива с glob (требуется `shopt -s globstar` в bash):

    javac -encoding UTF-8 -d out src/java/ru/mirea/kt3/**/*.java
    java -cp out ru.mirea.kt3.Main

В Windows PowerShell `find` заменяется на `Get-ChildItem`:

    javac -encoding UTF-8 -d out (Get-ChildItem -Recurse -Filter *.java src\java | ForEach-Object { $_.FullName })
    java -cp out ru.mirea.kt3.Main

Скомпилированные `.class` попадают в `out/ru/mirea/kt3/...` — структура
выходной папки всегда следует объявлению пакета. Запускать нужно именно
`ru.mirea.kt3.Main`.

## Входные данные
Тестовые данные захардкожены в `Main.java` и повторяют содержимое
`src/example_data.json` из процедурной версии КТ2 (Python 3.12):

- три товара: Стул (id 101), Стол (id 102), Лампа (id 103);
- три 3D-модели: chair/table/lamp в формате glTF со статусом «опубликована»;
- теги: дерево, кухня, мебель, офис, свет, декор;
- невалидная заявка `id=2, id_товароведа=5` (отсутствуют `id_модели` и `дата`);
- поисковый запрос `["дерево", "офис"]`.

## Ожидаемый вывод
    Заявка валидна: False
    Не хватает полей: ['id_модели', 'дата']

    Найдено моделей: 2
    - Стол (совпадений: 2)
    - Стул (совпадений: 1)

Вывод посимвольно совпадает с выводом процедурной версии
`python src/main.py` из КТ2.

## Тесты
Отдельных модульных тестов в этой контрольной точке нет. Корректность
проверяется запуском `Main` и сравнением вывода с процедурной версией.
