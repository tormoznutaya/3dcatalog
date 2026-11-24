package java.ru.mirea.kt3.validation;

import java.ru.mirea.kt3.domain.Model3D;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class FormatRule implements Rule<Model3D> {
    public static final Set<String> ALLOWED_FORMATS = Set.of("glTF", "GLB");

    @Override
    public ValidationResult validate(Model3D model) {
        List<String> errors = new ArrayList<>();
        if (!ALLOWED_FORMATS.contains(model.getFormat())) {
            errors.add("недопустимый формат: " + model.getFormat());
        }
        if (model.getFilePath() == null || model.getFilePath().isBlank()) {
            errors.add("не указан путь к файлу");
        }
        return errors.isEmpty() ? ValidationResult.ok() : ValidationResult.fail(errors);
    }
}