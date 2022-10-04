package za.co.rhubo.grassroots.errorhandling;

import org.springframework.http.ResponseEntity;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import za.co.rhubo.grassroots.errorhandling.exceptions.ProductException;
import za.co.rhubo.grassroots.errorhandling.exceptions.UserException;

import java.util.Arrays;

@ControllerAdvice
public class CustomControllerAdvice {

    @ExceptionHandler(UserException.class)
    public ResponseEntity<ErrorResponse> handle(UserException e){
        HttpStatus status = HttpStatus.PRECONDITION_FAILED;

        return new ResponseEntity<>(
                new ErrorResponse(status, e.getMessage()),
                status
        );
    }

    @ExceptionHandler(ProductException.class)
    public ResponseEntity<ErrorResponse> handle(ProductException e){
        HttpStatus status = HttpStatus.PRECONDITION_FAILED;

        return new ResponseEntity<>(
                new ErrorResponse(status, e.getMessage()),
                status
        );
    }

//    //This is a fallback method for all other exceptions
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ErrorResponse> handleExceptions(Exception e) {
//
//        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR; // 500
//
//        return new ResponseEntity<>(
//                new ErrorResponse(status, e.getMessage(), Arrays.toString(e.getStackTrace())),
//                status
//        );
//    }
}
