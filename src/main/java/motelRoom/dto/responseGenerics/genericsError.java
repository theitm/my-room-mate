package motelRoom.dto.responseGenerics;

public class genericsError<HttpStatus, T> {
    private HttpStatus error;
    private T message;

    public genericsError(HttpStatus error, T message) {
        this.error = error;
        this.message = message;
    }

    public HttpStatus getError() {
        return error;
    }

    public void setError(HttpStatus error) {
        this.error = error;
    }

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }
    }
