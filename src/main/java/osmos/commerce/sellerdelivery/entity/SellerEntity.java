package osmos.commerce.sellerdelivery.entity;

import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import osmos.commerce.common.generic.JsonType;
import osmos.commerce.sellerdelivery.dto.Position;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "seller")
@TypeDef(name = "JsonType", typeClass = JsonType.class)
public class SellerEntity extends BaseEntity{

    private static final String JSON_TYPE = "JsonType";

    private String name;

    private String type;

    private String address;

    private String locality;

    @Type(type = JSON_TYPE)
    private Position position;

    @OneToMany(mappedBy = "sellerId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<OrderEntity> orders;
}
