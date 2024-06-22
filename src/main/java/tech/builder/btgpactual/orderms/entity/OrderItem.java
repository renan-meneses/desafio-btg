package tech.builder.btgpactual.orderms.entity;

import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.math.BigDecimal;

public class OrderItem {

    private String product;
    private Integer quatity;
    @Field(targetType = FieldType.DECIMAL128)
    private BigDecimal price;


    public OrderItem(String product, Integer quatity, BigDecimal price) {
        this.product = product;
        this.quatity = quatity;
        this.price = price;
    }

    public String getProduct() {
        return this.product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Integer getQuatity() {
        return this.quatity;
    }

    public void setQuatity(Integer quatity) {
        this.quatity = quatity;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
