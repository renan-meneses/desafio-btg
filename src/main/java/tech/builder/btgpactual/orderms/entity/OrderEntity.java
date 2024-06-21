package tech.builder.btgpactual.orderms.entity;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.math.BigDecimal;
import java.util.List;

@Document(collection = "tb_orders" )
public class OrderEntity {

    @MongoId
    private Long orderId;

    private Long customerId;
    private BigDecimal total;
    private List<OrderItem> itemList;

    /**
     * get field @MongoId
     *
     * @return orderId @MongoId

     */
    public Long getOrderId() {
        return this.orderId;
    }

    /**
     * set field @MongoId
     *
     * @param orderId @MongoId

     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * get field
     *
     * @return customerId
     */
    public Long getCustomerId() {
        return this.customerId;
    }

    /**
     * set field
     *
     * @param customerId
     */
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    /**
     * get field
     *
     * @return total
     */
    public BigDecimal getTotal() {
        return this.total;
    }

    /**
     * set field
     *
     * @param total
     */
    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    /**
     * get field
     *
     * @return itemList
     */
    public List<OrderItem> getItemList() {
        return this.itemList;
    }

    /**
     * set field
     *
     * @param itemList
     */
    public void setItemList(List<OrderItem> itemList) {
        this.itemList = itemList;
    }
}
