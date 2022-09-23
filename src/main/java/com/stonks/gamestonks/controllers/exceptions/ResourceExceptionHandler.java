package com.stonks.gamestonks.controllers.exceptions;

import com.stonks.gamestonks.services.exceptions.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<StandardError> businessException(BusinessException e, HttpServletRequest req) {
        StandardError standardError = StandardError
                .builder()
                .error("Business Exception")
                .message(e.getMessage())
                .path(req.getRequestURI())
                .status(HttpStatus.BAD_REQUEST.value())
                .timestamp(Instant.now())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standardError);
    }

}
