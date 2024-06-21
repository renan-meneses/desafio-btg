package tech.builder.btgpactual.orderms.entity;

import java.math.BigDecimal;

public class OrderItemEntity {

    private Sting product;
    private Interger quatity;
    private BigDecimal price;

    /**
     * get field
     *
     * @return product
     */
    public Sting getProduct() {
        return this.product;
    }

    /**
     * set field
     *
     * @param product
     */
    public void setProduct(Sting product) {
        this.product = product;
    }

    /**
     * get field
     *
     * @return quatity
     */
    public Interger getQuatity() {
        return this.quatity;
    }

    /**
     * set field
     *
     * @param quatity
     */
    public void setQuatity(Interger quatity) {
        this.quatity = quatity;
    }

    /**
     * get field
     *
     * @return price
     */
    public BigDecimal getPrice() {
        return this.price;
    }

    /**
     * set field
     *
     * @param price
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
