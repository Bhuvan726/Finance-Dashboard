package com.finance.dashboard.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class FinancialRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private double amount;

    @NotNull
    private String type; // INCOME / EXPENSE

    @NotNull
    private String category;

    private String date;

    private String notes;

    private Long userId;

    // GETTERS

    public Long getId() { return id; }

    public double getAmount() { return amount; }

    public String getType() { return type; }

    public String getCategory() { return category; }

    public String getDate() { return date; }

    public String getNotes() { return notes; }

    public Long getUserId() { return userId; }

    // SETTERS

    public void setId(Long id) { this.id = id; }

    public void setAmount(double amount) { this.amount = amount; }

    public void setType(String type) { this.type = type; }

    public void setCategory(String category) { this.category = category; }

    public void setDate(String date) { this.date = date; }

    public void setNotes(String notes) { this.notes = notes; }

    public void setUserId(Long userId) { this.userId = userId; }
}