package com.salestax;

import java.math.BigDecimal;

public class ReceiptItem {
    
    private final int quantity;
    private final Product product;
    private final BigDecimal totalTax;
    private final BigDecimal totalPrice;

    public ReceiptItem(int quantity, Product product) {
        this.quantity = quantity;
        this.product = product;

        TaxCalculator taxCalculator = new TaxCalculator();
        this.totalTax = taxCalculator.calculateTax(product).multiply(BigDecimal.valueOf(quantity));
        this.totalPrice = product.getPrice().multiply(BigDecimal.valueOf(quantity)).add(totalTax);
    }

    public BigDecimal getTotalTax() {
        return totalTax;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public String toString() {
        return quantity + " " + product.getName() + " " + getTotalPrice();
    }

}
