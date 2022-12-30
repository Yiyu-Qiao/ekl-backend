package de.han.ekl.backend.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {UsernameOrPasswordInvalidException.class})
    public ResponseEntity<?> handleUsernameOrPasswordInvalidException(Exception exception){
        log.warn("Username or password invalid", exception);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<?> handleUnknownException(Exception exception){
        log.error("Unknown exception occured.", exception);
        return ResponseEntity.internalServerError().build();
    }
}
