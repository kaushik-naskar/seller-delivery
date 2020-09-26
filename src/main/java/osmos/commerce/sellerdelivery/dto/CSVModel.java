package osmos.commerce.sellerdelivery.dto;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CSVModel {

    @CsvBindByName
    private String storeName;

    @CsvBindByName
    private String storeLocality;

    @CsvBindByName
    private String storeAddress;

    @CsvBindByName
    private double srcLat;

    @CsvBindByName
    private double srcLong;

    @CsvBindByName
    private String paymentMode;

    @CsvBindByName
    private String customerName;

    @CsvBindByName
    private String customerMobile;

    @CsvBindByName
    private double destLat;

    @CsvBindByName
    private double destLong;

    @CsvBindByName
    private String customerAddress;

    @CsvBindByName
    private String customerLocality;

    @CsvBindByName
    private String customerPinCode;

    @CsvBindByName
    private String productName;

    @CsvBindByName
    private String description;

    @CsvBindByName
    private Integer quantity;

    @CsvBindByName
    private Double price;

    @CsvBindByName
    private String imageUrl;
}
