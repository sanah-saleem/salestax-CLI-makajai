package com.salestax;

public enum ProductCategory {

    BOOK(1, "Books", true),
    FOOD(2, "Food", true),
    MEDICAL(3, "Medical Products", true),
    OTHER(4, "others", false);

    private final int id;
    private final String displayName;
    private final boolean taxExempt;

    ProductCategory(int id, String displayName, boolean exempt) {
        this.id = id;
        this.displayName = displayName;
        this.taxExempt = exempt;
    }

    public boolean isTaxExempt() {
        return taxExempt;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getId() {
        return id;
    }

    public static ProductCategory fromId(int id) {
        for(ProductCategory category : values()) {
            if(category.getId() == id) {
                return category;
            }
        }
        throw new IllegalArgumentException("Invalid Category Id : " + id);
    }

    public static void printAllCategories() {
        System.out.println("Available categories:");
        for (ProductCategory category : values()) {
            String exemptStatus = category.isTaxExempt() ? "(Tax Exempt)" : "(Taxable)";
            System.out.println("  " + category.getId() + " = " + category.getDisplayName() + " " + exemptStatus);
        }
    }

}
