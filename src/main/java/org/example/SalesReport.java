
package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class SalesReport {

    public static void main(String[] args) {

        // STEP 1: Create sales inventory
        List<String> products = Arrays.asList(
                "Laptop", "Mouse", "Keyboard",
                "Monitor", "Mouse", "Laptop"
        );

        System.out.println("Original Products:");
        System.out.println(products);

        // STEP 2: Lambda Expression
        System.out.println("\nProducts using Lambda:");
        products.forEach(
                product -> System.out.println(product)
        );

        // STEP 3: Filter products using Streams
        List<String> filtered = products.stream()
                .filter(p -> p.startsWith("M"))
                .collect(Collectors.toList());

        System.out.println("\nFiltered Products:");
        System.out.println(filtered);

        // STEP 4: Remove duplicates using Streams
        List<String> unique = products.stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.println("\nUnique Products:");
        System.out.println(unique);

        // STEP 5: Sort products using Streams
        List<String> sorted = products.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println("\nSorted Products:");
        System.out.println(sorted);

        // STEP 6: Convert product names to uppercase
        List<String> uppercase = products.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println("\nUppercase Products:");
        System.out.println(uppercase);

        // STEP 7: Sales quantities
        Map<String, Integer> sales = new HashMap<>();

        sales.put("Laptop", 5);
        sales.put("Mouse", 20);
        sales.put("Keyboard", 10);
        sales.put("Monitor", 3);

        // STEP 8: Calculate total units sold
        int totalUnits = sales.values().stream()
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("\nTotal Units Sold: "
                + totalUnits);

        // STEP 9: Calculate total sales revenue
        Map<String, Integer> prices = new HashMap<>();

        prices.put("Laptop", 55000);
        prices.put("Mouse", 500);
        prices.put("Keyboard", 1500);
        prices.put("Monitor", 12000);

        int totalRevenue = sales.entrySet().stream()
                .mapToInt(entry ->
                        entry.getValue()
                                * prices.get(entry.getKey()))
                .sum();

        System.out.println("Total Sales Revenue: Rs."
                + totalRevenue);

        // STEP 10: Sales report using Streams
        System.out.println("\n--- SALES REPORT ---");

        sales.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> {
                    String name = entry.getKey();
                    int quantity = entry.getValue();
                    int revenue = quantity * prices.get(name);

                    System.out.println(
                            name + " | Units: " + quantity
                                    + " | Revenue: Rs." + revenue
                    );
                });

        System.out.println("\nDay 5 Completed Successfully!");
    }
}
