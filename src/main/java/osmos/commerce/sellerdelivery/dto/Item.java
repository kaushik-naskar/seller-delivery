package osmos.commerce.sellerdelivery.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    private String name;

    private String description;

    private Integer quantity;

    private Double price;

    private String imageUrl;
}
