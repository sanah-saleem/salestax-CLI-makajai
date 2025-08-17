package com.salestax;

import java.math.BigDecimal;

public class Product {

    private final String name;
    private final ProductCategory category;
    private final boolean imported;
    private final BigDecimal price;

    public Product(String name, ProductCategory category, boolean imported, BigDecimal price) {
        this.name = name;
        this.category = category;
        this.imported = imported;
        this.price = price;
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

    public BigDecimal getPrice() {
        return price;
    }

}
