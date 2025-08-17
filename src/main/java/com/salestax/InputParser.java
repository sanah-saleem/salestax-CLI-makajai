package com.salestax;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

public class InputParser {
    
    private final Scanner scanner;

    public InputParser(Scanner scanner) {
        this.scanner = scanner;
    }

    public Product parseProductInput(String line) {
        try {
            // Parse: "1 pizza at 15.99" or "1 imported pizza at 15.99"
            String[] parts = line.split(" at ");
            if (parts.length != 2) {
                throw new IllegalArgumentException("Invalid format. Use: '<quantity> <itemname> at <price>'");
            }

            BigDecimal price = new BigDecimal(parts[1].trim());
            String[] qtyAndName = parts[0].trim().split(" ", 2);
            String name = qtyAndName[1];
            boolean imported = Arrays.asList(name.toLowerCase().split(" "))
                          .contains("imported");
            
            ProductCategory category = findCategory(name);

            return new Product(name, category, imported, price);

        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Invalid input format: " + line + " , " + e.getMessage(), e);
        }
    }

    private ProductCategory findCategory(String productName) {
        String lower = productName.toLowerCase();
        if (lower.contains("book")) return ProductCategory.BOOK;
        if (lower.contains("chocolate") || lower.contains("pizza") || lower.contains("food")) return ProductCategory.FOOD;
        if (lower.contains("pill") || lower.contains("medicine") || lower.contains("headache")) return ProductCategory.MEDICAL;
        return ProductCategory.OTHER;
    }

    public int parseQuantity(String line) {
        String[] qtyAndName = line.split(" at ")[0].trim().split(" ", 2);
        return Integer.parseInt(qtyAndName[0]);
    }

}
