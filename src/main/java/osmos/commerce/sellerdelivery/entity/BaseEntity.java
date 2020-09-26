package osmos.commerce.sellerdelivery.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;

@Data
@MappedSuperclass
public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, updatable = false)
    private ZonedDateTime createdAt;

    @Column(nullable = false)
    private ZonedDateTime lastModifiedAt;

    @PrePersist
    public void onPrePersist() {
        this.createdAt = ZonedDateTime.now();
        this.lastModifiedAt = ZonedDateTime.now();
    }

    @PreUpdate
    public void onPreUpdate() {
        this.lastModifiedAt = ZonedDateTime.now();
    }

}

