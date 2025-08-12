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
            int quantity = Integer.parseInt(qtyAndName[0]);
            String name = qtyAndName[1];
            boolean imported = Arrays.asList(name.toLowerCase().split(" "))
                          .contains("imported");
            ProductCategory category = promptForCategory(name);

            return new Product(name, category, imported, price);

        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Invalid input format: " + line + " , " + e.getMessage(), e);
        }
    }

    private ProductCategory promptForCategory(String productName) {
        System.out.println("\nWhat category is '" + productName + "'?");
        ProductCategory.printAllCategories();
        
        while (true) {
            System.out.print("Enter category number (1-4): ");
            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());
                return ProductCategory.fromId(choice);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid choice. Please enter 1, 2, 3, or 4.");
            }
        }
    }

    public int parseQuantity(String line) {
        String[] qtyAndName = line.split(" at ")[0].trim().split(" ", 2);
        return Integer.parseInt(qtyAndName[0]);
    }

}
