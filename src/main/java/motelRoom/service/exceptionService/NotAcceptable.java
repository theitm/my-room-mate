package motelRoom.service.exceptionService;

public class NotAcceptable extends  RuntimeException {
    public NotAcceptable(String message) {
        super(message);
    }
}
