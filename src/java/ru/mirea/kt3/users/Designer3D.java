package ru.mirea.kt3.users;

import ru.mirea.kt3.domain.Model3D;
import ru.mirea.kt3.domain.User;

public class Designer3D extends User {
    public Designer3D(int id, String fullName) {
        super(id, fullName, "3D-дизайнер");
    }

    @Override
    public String describeRole() {
        return "3D-дизайнер: создаёт трёхмерную модель по фотографиям и характеристикам.";
    }

    public Model3D createModel(int modelId, int productId, String filePath, String format) {
        return new Model3D(modelId, productId, filePath, format, "черновик");
    }
}