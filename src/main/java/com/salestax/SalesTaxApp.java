package com.salestax;

import java.math.BigDecimal;
import java.util.Scanner;

public class SalesTaxApp {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        InputParser parser = new InputParser();
        Receipt receipt = new Receipt();
        TaxCalculator taxCalculator = new TaxCalculator();

        System.out.println("=== Sales Tax Calculator ===");
        System.out.println("Enter items in format: 'quantity itemname at price'");
        System.out.println("Examples:");
        System.out.println("  1 book at 12.49");
        System.out.println("  1 imported perfume at 47.50");
        System.out.println("  2 chocolate bars at 0.85");
        System.out.println("\nType 'done' when finished.\n");

        while(true) {
            System.out.println("Enter item : ");
            String line = scanner.nextLine().trim();

            if(line.equalsIgnoreCase("done")) break;

            if(line.isEmpty()) continue;

            try {
                int quantity = parser.parseQuantity(line);
                Product product = parser.parseProductInput(line);
                receipt.addReceiptItem(new ReceiptItem(quantity, product, taxCalculator));
            }
            catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Please try again.");
            }
        }

        if (receipt.totalAmount().equals(BigDecimal.ZERO)) {
            System.out.println("No items entered. Goodbye!");
            scanner.close();
            return;
        }

        System.out.println("\n" + "=".repeat(30));
        System.out.println("RECEIPT");
        System.out.println("=".repeat(30));
     
        receipt.print();
        
        scanner.close();

    }        
}
