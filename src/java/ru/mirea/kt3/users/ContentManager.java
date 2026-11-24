package ru.mirea.kt3.users;

import ru.mirea.kt3.domain.Model3D;
import ru.mirea.kt3.domain.User;
import ru.mirea.kt3.validation.Rule;
import ru.mirea.kt3.validation.ValidationResult;
public class ContentManager extends User {
    public ContentManager(int id, String fullName) {
        super(id, fullName, "контент-менеджер");
    }

    @Override
    public String describeRole() {
        return "Контент-менеджер: проверяет модель, загружает её в каталог и публикует.";
    }
    public boolean validateAndPublish(Model3D model, Rule<Model3D> rule) {
        ValidationResult result = rule.validate(model);
        if (!result.isOk()) {
            return false;
        }
        model.setStatus("опубликована");
        return true;
    }
}