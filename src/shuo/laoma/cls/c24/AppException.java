package shuo.laoma.cls.c24;

public class AppException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public AppException() {
        super();
    }

    public AppException(String message,
            Throwable cause) {
        super(message, cause);
    }

    public AppException(String message) {
        super(message);
    }

    public AppException(Throwable cause) {
        super(cause);
    }
}
