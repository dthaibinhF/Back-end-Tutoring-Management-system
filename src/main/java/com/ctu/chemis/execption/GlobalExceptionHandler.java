package com.ctu.chemis.execption;

import com.ctu.chemis.execption.response.MissMatchResponse;
import com.ctu.chemis.execption.response.NotFoundResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<NotFoundResponse> handleException(NotFoundException notFoundException) {

        NotFoundResponse error = new NotFoundResponse();

        error.setMessage(notFoundException.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MissMatchException.class)
    public ResponseEntity<MissMatchResponse> handleResourceNotFoundException(MissMatchException ex) {

        MissMatchResponse error = new MissMatchResponse();
        error.setMessage(ex.getMessage());
        error.setStatus(HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
