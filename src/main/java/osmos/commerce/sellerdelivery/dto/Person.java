package osmos.commerce.sellerdelivery.dto;

import lombok.Data;

@Data
public class Person {

    private String name;

    private String mobileNumber;

    private String address;

    private String locality;

    private Position coordinate;

    private String pinCode;
}
