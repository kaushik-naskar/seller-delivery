package osmos.commerce.sellerdelivery.entity;

import org.hibernate.annotations.TypeDef;
import osmos.commerce.common.generic.JsonType;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "seller")
@TypeDef(name = "JsonType", typeClass = JsonType.class)
public class SellerEntity extends BaseEntity{

    private static final String JSON_TYPE = "JsonType";

    private String name;

    private String type;

    private String address;

    @OneToMany(mappedBy = "sellerId", fetch = FetchType.LAZY)
    private List<OrderEntity> orders;
}
