package ru.mirea.kt3.domain;
public abstract class User {
    private final int id;
    private final String fullName;
    private final String role;

    protected User(int id, String fullName, String role) {
        this.id = id;
        this.fullName = fullName;
        this.role = role;
    }

    public int getId() { return id; }
    public String getFullName() { return fullName; }
    public String getRole() { return role; }

    public abstract String describeRole();
}