package image;

public class NotSupportedException extends RuntimeException {
    public String message;

    public NotSupportedException(String message)
    {
        this.message = message;
    }
}
