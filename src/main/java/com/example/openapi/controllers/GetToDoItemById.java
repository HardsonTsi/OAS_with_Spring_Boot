package com.example.openapi.controllers;

import com.example.openapi.models.ToDoItem;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class GetToDoItemById {
    @GetMapping("/todos/{toDoItemId}")
    @Operation(
            tags = {"TodoItems"}
    )
    public ResponseEntity<Object> getToDoItemById(@PathVariable String toDoItemId) {
        Boolean completed = new Random().nextBoolean();
        return ResponseEntity.ok().body(new ToDoItem(toDoItemId, "Item " + toDoItemId + " description", completed));
    }
}
