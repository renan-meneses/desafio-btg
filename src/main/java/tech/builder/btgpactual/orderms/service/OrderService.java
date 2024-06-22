package tech.builder.btgpactual.orderms.service;

import java.util.List;
import java.math.BigDecimal;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;
import tech.builder.btgpactual.orderms.entity.OrderItem;
import tech.builder.btgpactual.orderms.entity.OrderEntity;
import tech.builder.btgpactual.orderms.repository.OrderRepository;
import tech.builder.btgpactual.orderms.controller.dto.OrderResponse;
import tech.builder.btgpactual.orderms.listener.dto.OrdderCreateEvent;


@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void save (OrdderCreateEvent event){

        var entity = new OrderEntity();
        entity.setOrderId(event.codigoPedido());
        entity.setCustomerId(event.codigoCliente());
        entity.setItemList(getOrderItens(event));
        entity.setTotal(getTotal(event));

        orderRepository.save(entity);
    }

    private static List<OrderItem> getOrderItens(OrdderCreateEvent event) {
        return event.itens()
                .stream()
                .map(i -> new OrderItem(
                        i.produto(),
                        i.quantidade(),
                        i.preco()))
                .toList();
    }

    private BigDecimal getTotal(OrdderCreateEvent event){
        return event.itens()
                .stream()
                .map(i -> i.preco().multiply(BigDecimal.valueOf(i.quantidade())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    public Page<OrderResponse> findAllByCustomerId(Long customerId, PageRequest pageRequest){
        var orders = orderRepository.findAllByCustomerId( customerId, pageRequest);
        return orders.map(OrderResponse::fromEntity);
    }
}
