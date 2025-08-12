package com.salestax;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Receipt {
    
    private final List<ReceiptItem> receiptItems = new ArrayList<>();

    public void addReceiptItem(ReceiptItem receiptItem) {
        receiptItems.add(receiptItem);
    }

    public BigDecimal totalSalesTax() {
        return receiptItems.stream()
                    .map(ReceiptItem::getTotalTax)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal totalAmount() {
        return receiptItems.stream()
                    .map(ReceiptItem::getTotalPrice)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void print() {
        receiptItems.forEach(i -> System.out.println(i));
        System.out.println("Sales Tax : " + totalSalesTax());
        System.out.println("Total : " + totalAmount());
    }
    
}
