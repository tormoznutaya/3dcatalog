package java.ru.mirea.kt3.validation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ValidationResult {
    private final boolean ok;
    private final List<String> errors;

    private ValidationResult(boolean ok, List<String> errors) {
        this.ok = ok;
        this.errors = new ArrayList<>(errors);
    }

    public static ValidationResult ok() {
        return new ValidationResult(true, List.of());
    }

    public static ValidationResult fail(List<String> errors) {
        return new ValidationResult(false, errors);
    }

    public boolean isOk() { return ok; }
    public List<String> getErrors() { return Collections.unmodifiableList(errors); }
}