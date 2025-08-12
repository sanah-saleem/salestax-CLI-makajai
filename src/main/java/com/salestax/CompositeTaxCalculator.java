package com.salestax;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CompositeTaxCalculator implements ITaxCalculator{

    private final List<ITaxCalculator> calculators = new ArrayList<>();

    public void addCalculator(ITaxCalculator calc) {
        calculators.add(calc);
    }

    @Override
    public BigDecimal calculateTax(BigDecimal price) {
        
        return calculators.stream()
                    .map( c -> c.calculateTax(price))
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

    }
    
}
