package ru.mirea.kt3.validation;

import ru.mirea.kt3.domain.Request;

import java.util.ArrayList;
import java.util.List;

public class CompletenessRule implements Rule<Request> {
    private static final List<String> REQUIRED_FIELDS = List.of("id_товароведа", "id_модели", "дата");


    public static List<String> getRequiredFields() {
        return REQUIRED_FIELDS;
    }

    @Override
    public ValidationResult validate(Request req) {
        List<String> missing = new ArrayList<>();
        if (req.getUserId() == null) missing.add("id_товароведа");
        if (req.getModelId() == null) missing.add("id_модели");
        if (req.getDate() == null) missing.add("дата");
        if (missing.isEmpty()) {
            return ValidationResult.ok();
        }
        return ValidationResult.fail(missing);
    }
}