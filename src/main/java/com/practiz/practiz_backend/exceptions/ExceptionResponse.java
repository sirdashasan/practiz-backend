package com.practiz.practiz_backend.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ExceptionResponse {

    private String message;
    private int status;
    private LocalDateTime dateTime;
}
