package com.springbootlearning.SpringBootPaginationSorting.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotResourceFoundException extends RuntimeException {
    public NotResourceFoundException(String message) {
        super(message);

    }
}
