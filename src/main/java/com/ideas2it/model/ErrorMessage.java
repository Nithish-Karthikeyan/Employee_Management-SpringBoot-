package com.ideas2it.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
@AllArgsConstructor
public class ErrorMessage {
    private HttpStatus status;
    private String message;
}
