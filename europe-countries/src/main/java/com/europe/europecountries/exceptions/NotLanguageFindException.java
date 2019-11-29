package com.europe.europecountries.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotLanguageFindException extends RuntimeException {
    public NotLanguageFindException() {
        super();
    }

    public NotLanguageFindException(String message) {
        super(message);
    }

    public NotLanguageFindException(String message, Throwable cause) {
        super(message, cause);
    }
}
