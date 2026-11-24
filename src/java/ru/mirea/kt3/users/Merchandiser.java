package ru.mirea.kt3.users;

import ru.mirea.kt3.domain.Request;
import ru.mirea.kt3.domain.User;

import java.time.LocalDate;

public class Merchandiser extends User {
    public Merchandiser(int id, String fullName) {
        super(id, fullName, "товаровед");
    }

    @Override
    public String describeRole() {
        return "Товаровед: инициирует добавление товара, формирует заявку на 3D-модель.";
    }

    public Request createRequest(int requestId, int modelId) {
        return new Request(requestId, getId(), modelId, LocalDate.now());
    }
}