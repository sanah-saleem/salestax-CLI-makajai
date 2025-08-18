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

    public static Product createProduct(String name, BigDecimal price) {
        boolean imported = name.toLowerCase().contains("imported");
        ProductCategory category = determineCategory(name);
        return new Product(name, category, imported, price);
    }

    public static ProductCategory determineCategory(String productName) {
        String lower = productName.toLowerCase();
        if (lower.contains("book")) return ProductCategory.BOOK;
        if (lower.contains("chocolate") || lower.contains("pizza") || lower.contains("food")) return ProductCategory.FOOD;
        if (lower.contains("pill") || lower.contains("medicine") || lower.contains("headache")) return ProductCategory.MEDICAL;
        return ProductCategory.OTHER;
    }

    public boolean isTaxExempt() {
        return category.isTaxExempt();
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
