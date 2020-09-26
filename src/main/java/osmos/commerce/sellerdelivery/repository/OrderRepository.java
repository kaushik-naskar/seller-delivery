package osmos.commerce.sellerdelivery.repository;

import org.springframework.data.repository.CrudRepository;
import osmos.commerce.sellerdelivery.entity.OrderEntity;

public interface OrderRepository extends CrudRepository<OrderEntity, Integer> {
}
