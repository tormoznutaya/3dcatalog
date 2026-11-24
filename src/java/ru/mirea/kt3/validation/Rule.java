package ru.mirea.kt3.validation;
public interface Rule<T> {
    ValidationResult validate(T target);
}