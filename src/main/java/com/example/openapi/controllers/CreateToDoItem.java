package com.example.openapi.controllers;

import com.example.openapi.models.ToDoItem;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateToDoItem {
    @PostMapping("/todos")
    @Operation(
            tags = {"TodoItems"}
    )
    public ResponseEntity<Object> createToDoItem(@RequestBody ToDoItem toDoItem) {
        return ResponseEntity.ok().body(toDoItem);
    }
}
