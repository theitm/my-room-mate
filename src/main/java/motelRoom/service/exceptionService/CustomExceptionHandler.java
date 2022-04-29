package motelRoom.service.exceptionService;

import motelRoom.dto.responseException.ResponseError;
import motelRoom.dto.responseGenerics.genericsError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class CustomExceptionHandler {
    /**
     * Show error 400
     * @return
     */
    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public genericsError handleCustomException(BadRequestException ex, WebRequest req){
        return new genericsError((Object) HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    /**
     * Show error 404
     * @return
     */
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public genericsError handleNotFoundException(NotFoundException ex, WebRequest req){
        return new genericsError((Object) HttpStatus.NOT_FOUND, ex.getMessage());
    }

    /**
     * Show error 406
     * @return
     */
    @ExceptionHandler(NotAcceptable.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public genericsError handleNotAcceptableException(NotAcceptable ex, WebRequest req){
        return new genericsError((Object) HttpStatus.NOT_ACCEPTABLE, ex.getMessage());
    }
}
