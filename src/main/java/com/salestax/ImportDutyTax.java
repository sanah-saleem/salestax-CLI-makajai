package com.salestax;

import java.math.BigDecimal;

public class ImportDutyTax implements ITaxCalculator{

    private static final BigDecimal RATE = new BigDecimal("0.05");

    @Override
    public BigDecimal calculateTax(BigDecimal price) {
        
        return RoundingUtil.roundUpToNearestFiveCents(price.multiply(RATE));

    }
    
}
