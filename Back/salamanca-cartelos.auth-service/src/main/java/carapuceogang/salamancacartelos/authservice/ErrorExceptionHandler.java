package carapuceogang.salamancacartelos.authservice;

import carapuceogang.salamancacartelos.authservice.models.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ErrorExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler
    protected ResponseEntity<Object> handleException(RuntimeException e, WebRequest request) {
        ErrorResponse error = new ErrorResponse(e.getMessage());
        return handleExceptionInternal(e, error, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}