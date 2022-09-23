package com.example.openapi.controllers;

import com.example.openapi.models.ToDoItem;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;
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
                            @Content(schema = @Schema(implementation = ToDoItem.class))
                    }
            ),
            parameters = {
                    @Parameter(
                            name = "toDoItemId",
                            description = "The path variable",
                            example = "555",
                            in = ParameterIn.PATH
                    )
            },
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Success Resposne",
                            content = @Content(schema = @Schema(implementation = ToDoItem.class), mediaType = MediaType.APPLICATION_JSON_VALUE)
                    )
            }
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
