package com.api.simpleuserscore.controller.exceptionHandle;
import com.api.simpleuserscore.error.UserErrorResponse;
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
    // Add exception handler ... to catch any exception (catch all)

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
