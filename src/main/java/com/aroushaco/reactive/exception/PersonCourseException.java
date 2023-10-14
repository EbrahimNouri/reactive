package com.aroushaco.reactive.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(HttpStatus.)
public class PersonCourseException extends RuntimeException {
    public PersonCourseException() {
    }

    public PersonCourseException(String message) {
        super(message);
    }

    public PersonCourseException(String message, Throwable cause) {
        super(message, cause);
    }

    public PersonCourseException(Throwable cause) {
        super(cause);
    }

    public PersonCourseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
