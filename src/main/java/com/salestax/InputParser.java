package com.salestax;

import java.math.BigDecimal;

public class InputParser {

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

            return Product.createProduct(name, price);

        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Invalid input format: " + line + " , " + e.getMessage(), e);
        }
    }

    public int parseQuantity(String line) {
        String[] qtyAndName = line.split(" at ")[0].trim().split(" ", 2);
        return Integer.parseInt(qtyAndName[0]);
    }

}
