package com.example.openapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToDoItem {
    private String itemId;
    private String title;
    private String description;
    private Boolean completed;

    public ToDoItem(String title, String description, Boolean completed) {
        this.title = title;
        this.description = description;
        this.completed = completed;
    }
}
