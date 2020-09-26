package osmos.commerce.sellerdelivery.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CSVModel {

    private String sellerName;

    private String sellerLocality;

    private String sellerAddress;

    private double srcLat;

    private double srcLong;

    private String paymentMode;

    private String customerName;

    private String customerMobile;

    private double destLat;

    private double destLong;

    private String customerAddress;

    private String customerLocality;

    private String customerPinCode;

    private String productName;

    private String description;

    private Integer quantity;

    private Double price;

    private String imageUrl;
}
