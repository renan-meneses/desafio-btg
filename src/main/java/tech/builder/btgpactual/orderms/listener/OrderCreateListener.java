package tech.builder.btgpactual.orderms.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import tech.builder.btgpactual.orderms.service.OrderService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import tech.builder.btgpactual.orderms.listener.dto.OrdderCreateEvent;
import static tech.builder.btgpactual.orderms.config.RabbitMqConfig.ORDER_CREATED_QUEUE;


@Component
public class OrderCreateListener {

    private final Logger logger = LoggerFactory.getLogger(OrderCreateListener.class);

    private final OrderService orderService;

    public OrderCreateListener(OrderService orderService) {
        this.orderService = orderService;
    }

    @RabbitListener(queues = ORDER_CREATED_QUEUE)
    public  void listen(Message<OrdderCreateEvent> message){
        try{
            orderService.save(message.getPayload());
            logger.info("Message Consumed: {}", message);
        } catch (Exception ex) {
            logger.error("An unexpected error occurred: {}", ex.getMessage());
        }
    }
}
