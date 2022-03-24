package com.api.simpleuserscore.controller.exceptionHandle;
import com.api.simpleuserscore.error.UserErrorResponse;
import com.api.simpleuserscore.error.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Joy Roy
 * @version 1.0
 * @since 3/24/2022
 */
@ControllerAdvice
public class UserExceptionHandler {
    // Add an exception handler for UserNotFoundException
    @ExceptionHandler
    public ResponseEntity<UserErrorResponse> handleException(UserNotFoundException exc) {
        // create UserErrorResponse
        UserErrorResponse error = new UserErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                exc.getMessage(),
                System.currentTimeMillis());
        // return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // Add another exception handler ... to catch any exception (catch all)
    @ExceptionHandler
    public ResponseEntity<UserErrorResponse> handleException(Exception exc) {
        // create UserErrorResponse
        UserErrorResponse error = new UserErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                exc.getMessage(),
                System.currentTimeMillis());
        // return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
