package osmos.commerce.sellerdelivery.dto;

import lombok.Data;

@Data
public class Item {

    private String name;

    private String description;

    private Integer quantity;

    private Double price;

    private String imageUrl;
}
