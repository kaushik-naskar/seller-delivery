package osmos.commerce.sellerdelivery.exception;

import lombok.Data;

@Data
public class BaseException extends RuntimeException{

    BaseException(String error, String message){
        super(message);
    }

    private String message;

    private String error;
}
