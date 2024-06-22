package tech.builder.btgpactual.orderms.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tech.builder.btgpactual.orderms.entity.OrderEntity;

public interface OrderRepository extends MongoRepository<OrderEntity, Long> {

}
