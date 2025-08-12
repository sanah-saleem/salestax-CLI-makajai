package com.salestax;

import java.math.BigDecimal;

public class Product {

    private final String name;
    private final ProductCategory category;
    private final boolean imported;
    private final BigDecimal price;
    private final ITaxCalculator taxCalculator;

    public Product(String name, ProductCategory category, boolean imported, BigDecimal price) {
        this.name = name;
        this.category = category;
        this.imported = imported;
        this.price = price;
        this.taxCalculator = initTaxCalculator();
    }

    private ITaxCalculator initTaxCalculator() {
        CompositeTaxCalculator compositeTaxCalculator = new CompositeTaxCalculator();
        if(!category.isTaxExempt()) {
            compositeTaxCalculator.addCalculator(new BasicSalesTax());
        }
        if(imported) {
            compositeTaxCalculator.addCalculator(new ImportDutyTax());
        }
        return compositeTaxCalculator;
    }

    public BigDecimal totalTax() {
        return taxCalculator.calculateTax(price);
    }

    public BigDecimal totalPrice() {
        return price.add(totalTax());
    }

    public String getName() {
        return name;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public boolean isImported() {
        return imported;
    }

}
