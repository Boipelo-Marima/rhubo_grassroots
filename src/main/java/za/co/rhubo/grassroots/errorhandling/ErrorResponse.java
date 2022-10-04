package za.co.rhubo.grassroots.errorhandling;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;


public class ErrorResponse {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime timestamp;

    private int code;

    private String status;

    private String message;

    String stackTrace;

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public int getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public ErrorResponse() {
        timestamp = LocalDateTime.now();
    }

    public ErrorResponse(HttpStatus httpStatus, String message) {
        this();
        this.code = httpStatus.value();
        this.status = httpStatus.name();
        this.message = message;
        if(stackTrace == null)
            this.stackTrace = "Stack Trace not provided";
    }

    public ErrorResponse(HttpStatus httpStatus, String message, String stackTrace) {
        this(httpStatus, message);
        this.stackTrace = stackTrace;
    }
}
