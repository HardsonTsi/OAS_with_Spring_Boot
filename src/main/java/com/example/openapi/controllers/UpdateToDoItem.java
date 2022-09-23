package com.example.openapi.controllers;

import com.example.openapi.models.Customer;
import com.example.openapi.models.ToDoItem;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UpdateToDoItem {
    @PutMapping("/todos/{toDoItemId}")
    @Operation(
            tags = {"TodoItems", "TodoItem2"},
            operationId = "updateTodo",
            summary = "This is summary",
            description = "This is the description",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "This is request body descritpion.",
                    content = {
                            @Content(schema = @Schema(implementation = Customer.class))
                    }
            )
    )
    public ResponseEntity<Object> updateToDoItem(@PathVariable String toDoItemId,
                                                 @RequestBody ToDoItem toDoItem,
                                                 @CookieValue(required = false) String canEdit,
                                                 @RequestHeader Boolean fromHost,
                                                 @RequestParam Boolean isClient
    ) {
        return ResponseEntity.ok().body(toDoItem);
    }
}
