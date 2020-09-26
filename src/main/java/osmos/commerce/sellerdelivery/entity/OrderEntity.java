package osmos.commerce.sellerdelivery.entity;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import osmos.commerce.common.generic.JsonType;
import osmos.commerce.sellerdelivery.dto.Item;
import osmos.commerce.sellerdelivery.dto.Position;
import osmos.commerce.sellerdelivery.dto.Status;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Table(name = "seller_order")
@TypeDef(name = "JsonType", typeClass = JsonType.class)
public class OrderEntity extends BaseEntity{

    private static final String JSON_TYPE = "JsonType";

    @Enumerated(EnumType.STRING)
    private Status status;

    private ZonedDateTime promisedETA;

    private ZonedDateTime expectedETA;

    @Type(type = JSON_TYPE)
    private Position destinationCoordinates;

    @Type(type = JSON_TYPE)
    private List<Item> items;

    private String reason;

    private String paymentMode;

    private Integer sellerId;

}
