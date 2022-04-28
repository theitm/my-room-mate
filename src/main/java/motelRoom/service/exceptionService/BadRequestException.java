package motelRoom.service.exceptionService;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String message) {
        super(message);
    }
}