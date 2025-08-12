package com.salestax;

import java.math.BigDecimal;

public class ReceiptItem {
    
    private final int quantity;
    private final Product product;

    public ReceiptItem(int quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }

    public BigDecimal getTotalTax() {
        return product.totalTax().multiply(BigDecimal.valueOf(quantity));
    }

    public BigDecimal getTotalPrice() {
        return product.totalPrice().multiply(BigDecimal.valueOf(quantity));
    }

    public String toString() {
        return quantity + " " + product.getName() + " " + getTotalPrice();
    }

}
