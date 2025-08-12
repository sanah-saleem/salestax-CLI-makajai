package com.salestax;

import java.math.BigDecimal;

public interface ITaxCalculator {
    
    BigDecimal calculateTax(BigDecimal price);

}
