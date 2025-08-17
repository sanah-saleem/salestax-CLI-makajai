package com.salestax;

import java.math.BigDecimal;

public class TaxCalculator {
    
    private static final BigDecimal BASIC_TAX_RATE = new BigDecimal("0.10");
    private static final BigDecimal IMPORT_TAX_RATE = new BigDecimal("0.05");

    public BigDecimal calculateTax(Product product) {
        BigDecimal tax = BigDecimal.ZERO;

        // Apply basic tax if the product is not exempt
        if (!product.getCategory().isTaxExempt()) {
            tax = tax.add(product.getPrice().multiply(BASIC_TAX_RATE));
        }

        // Apply import tax if the product is imported
        if (product.isImported()) {
            tax = tax.add(product.getPrice().multiply(IMPORT_TAX_RATE));
        }

        // Round up to the nearest 0.05
        return RoundingUtil.roundUpToNearestFiveCents(tax);
        
    }

}
