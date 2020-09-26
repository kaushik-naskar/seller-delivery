package osmos.commerce.sellerdelivery.exception;

public class NotFoundException extends BaseException{

    private static final String DEFAULT_ERROR = "NOT_FOUND";

    NotFoundException(String error, String message) {
        super(error, message);
    }

    public static NotFoundException fileNotFoundException(String message){
        return new NotFoundException(DEFAULT_ERROR,message);
    }
}
