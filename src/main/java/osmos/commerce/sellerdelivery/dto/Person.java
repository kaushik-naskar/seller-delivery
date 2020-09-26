package osmos.commerce.sellerdelivery.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    private String name;

    private String mobileNumber;

    private String address;

    private String locality;

    private Position coordinate;

    private String pinCode;
}
