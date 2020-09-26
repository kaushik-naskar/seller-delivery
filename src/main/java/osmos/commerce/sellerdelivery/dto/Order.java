package osmos.commerce.sellerdelivery.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private String orderId;

    private ZonedDateTime createdAt;

    private Status status;

    private ZonedDateTime promisedETA;

    private ZonedDateTime expectedETA;

    private Position destinationCoordinates;

    private List<Item> items;

    private String reason;

    private String paymentMode;

}
