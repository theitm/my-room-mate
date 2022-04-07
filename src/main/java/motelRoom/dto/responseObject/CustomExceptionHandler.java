package motelRoom.dto.responseObject;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import javax.lang.model.element.Name;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(CustomException.class)
    public ResponseError handleCustomException(CustomException ex, WebRequest req){
        return new ResponseError(HttpStatus.BAD_REQUEST, ex.getMessage());
    }
}
