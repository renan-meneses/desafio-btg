package tech.builder.btgpactual.orderms.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import tech.builder.btgpactual.orderms.service.OrderService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tech.builder.btgpactual.orderms.controller.dto.ApiResponse;
import tech.builder.btgpactual.orderms.controller.dto.OrderResponse;
import tech.builder.btgpactual.orderms.controller.dto.PaginationResponser;

@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("customers/{customerId}/orders")
    public ResponseEntity<ApiResponse<OrderResponse>> listOrders(@PathVariable("customerId") Long customerId,
                                                                @RequestParam(name = "page", defaultValue = "0") Integer page,
                                                                @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize){
        var pageResponse = orderService.findAllByCustomerId(customerId, PageRequest.of(page,pageSize));

        return  ResponseEntity.ok(new ApiResponse<>(
                pageResponse.getContent(),
                PaginationResponser.fromPage(pageResponse)
        ));
    }
}
