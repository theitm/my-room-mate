package motelRoom.dto.responseObject;

public class CustomException extends RuntimeException{
    public CustomException(String message) {
        super(message);
    }
}
