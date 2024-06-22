package tech.builder.btgpactual.orderms.listener.dto;


import java.util.List;

public record OrdderCreateEvent(Long codigoPedido,
                                Long codigoCliente,
                                List<OrderItemEvent> itens) {

}
