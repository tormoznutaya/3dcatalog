package ru.mirea.kt3.domain;

import java.time.LocalDate;
public class Request {
    private final int id;
    private Integer userId;
    private Integer modelId;
    private LocalDate date;

    public Request(int id, Integer userId, Integer modelId, LocalDate date) {
        this.id = id;
        this.userId = userId;
        this.modelId = modelId;
        this.date = date;
    }

    public int getId() { return id; }
    public Integer getUserId() { return userId; }
    public Integer getModelId() { return modelId; }
    public LocalDate getDate() { return date; }

    public void setUserId(Integer userId) { this.userId = userId; }
    public void setModelId(Integer modelId) { this.modelId = modelId; }
    public void setDate(LocalDate date) { this.date = date; }
}