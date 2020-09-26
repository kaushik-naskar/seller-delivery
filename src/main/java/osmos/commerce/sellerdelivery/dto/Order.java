package osmos.commerce.sellerdelivery.dto;

import lombok.Data;

import java.time.ZonedDateTime;
import java.util.List;

@Data
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
