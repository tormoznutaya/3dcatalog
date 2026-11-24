package ru.mirea.kt3;

import ru.mirea.kt3.catalog.Catalog;
import ru.mirea.kt3.domain.Model3D;
import ru.mirea.kt3.domain.Product;
import ru.mirea.kt3.domain.Request;
import ru.mirea.kt3.domain.Tag;
import ru.mirea.kt3.search.SearchResult;
import ru.mirea.kt3.search.TagSearchStrategy;
import ru.mirea.kt3.validation.CompletenessRule;
import ru.mirea.kt3.validation.Rule;
import ru.mirea.kt3.validation.ValidationResult;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
public class Main {
    public static void main(String[] args) {
        Catalog catalog = loadTestData();

        // Алгоритм 1: проверка комплектности заявки (невалидная — нет id_модели и даты)
        Request invalid = new Request(2, 5, null, null);
        Rule<Request> completeness = new CompletenessRule();
        ValidationResult result = completeness.validate(invalid);
        // Python печатает True/False с большой буквы — повторяем это поведение.
        String okStr = result.isOk() ? "True" : "False";
        System.out.println("Заявка валидна: " + okStr);
        if (!result.isOk()) {
            String joined = result.getErrors().stream()
                    .map(s -> "'" + s + "'")
                    .collect(Collectors.joining(", ", "[", "]"));
            System.out.println("Не хватает полей: " + joined);
        }
        System.out.println();

        // Алгоритм 2: поиск моделей по тегам
        List<String> query = List.of("дерево", "офис");
        List<SearchResult> found = catalog.search(query, new TagSearchStrategy());
        System.out.println("Найдено моделей: " + found.size());
        for (SearchResult item : found) {
            System.out.println("- " + catalog.modelName(item.getModel())
                    + " (совпадений: " + item.getMatches() + ")");
        }
    }
    private static Catalog loadTestData() {
        Catalog catalog = new Catalog();

        // Товары
        catalog.addProduct(new Product(101, "Стул", "Кухонный стул из дерева", new BigDecimal("2990.00")));
        catalog.addProduct(new Product(102, "Стол", "Офисный стол", new BigDecimal("7490.00")));
        catalog.addProduct(new Product(103, "Лампа", "Декоративная лампа", new BigDecimal("1490.00")));

        // Теги
        Tag tWood = new Tag(1, "дерево");
        Tag tKitchen = new Tag(2, "кухня");
        Tag tFurniture = new Tag(3, "мебель");
        Tag tOffice = new Tag(4, "офис");
        Tag tLight = new Tag(5, "свет");
        Tag tDecor = new Tag(6, "декор");

        // Модели
        Model3D chairModel = new Model3D(1, 101, "chair.gltf", "glTF", "опубликована");
        chairModel.addTag(tWood);
        chairModel.addTag(tKitchen);
        chairModel.addTag(tFurniture);

        Model3D tableModel = new Model3D(2, 102, "table.gltf", "glTF", "опубликована");
        tableModel.addTag(tWood);
        tableModel.addTag(tOffice);
        tableModel.addTag(tFurniture);

        Model3D lampModel = new Model3D(3, 103, "lamp.gltf", "glTF", "опубликована");
        lampModel.addTag(tLight);
        lampModel.addTag(tDecor);

        catalog.addModel(chairModel);
        catalog.addModel(tableModel);
        catalog.addModel(lampModel);

        return catalog;
    }
}