package osmos.commerce.sellerdelivery.entity;

import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import osmos.commerce.common.generic.JsonType;
import osmos.commerce.sellerdelivery.dto.Item;
import osmos.commerce.sellerdelivery.dto.Person;
import osmos.commerce.sellerdelivery.dto.Position;
import osmos.commerce.sellerdelivery.dto.Status;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.time.ZonedDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "seller_order")
@TypeDef(name = "JsonType", typeClass = JsonType.class)
public class OrderEntity extends BaseEntity{

    private static final String JSON_TYPE = "JsonType";

    @Enumerated(EnumType.STRING)
    private Status status = Status.PENDING;

    private ZonedDateTime promisedETA = ZonedDateTime.now().plusDays(3);

    private ZonedDateTime expectedETA;

    @Type(type = JSON_TYPE)
    private Position position;

    @Type(type = JSON_TYPE)
    private List<Item> items;

    @Type(type = JSON_TYPE)
    private Person customer;

    private String reason;

    private String paymentMode = "PRE-PAID";

    private Integer sellerId;

}
