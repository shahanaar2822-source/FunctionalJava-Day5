
package org.example;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class StreamsPractice {

    public static void main(String[] args) {

        List<String> products = List.of(
                "Laptop", "Mouse", "Keyboard",
                "Mouse", "Monitor"
        );

        // 1. Predicate - Test a condition
        Predicate<String> startsWithM =
                name -> name.startsWith("M");

        System.out.println("1. Filtered Products:");
        products.stream()
                .filter(startsWithM)
                .forEach(System.out::println);

        // 2. Function - Transform data
        Function<String, String> uppercase =
                String::toUpperCase;

        System.out.println("\n2. Uppercase Products:");
        products.stream()
                .map(uppercase)
                .forEach(System.out::println);

        // 3. Optional - Handle missing values
        Optional<String> found = products.stream()
                .filter(p -> p.equals("Monitor"))
                .findFirst();

        System.out.println("\n3. Search Result:");
        System.out.println(
                found.orElse("Product not found")
        );

        // 4. Reduce - Calculate total
        List<Integer> amounts = List.of(100, 200, 300);

        int total = amounts.stream()
                .reduce(0, Integer::sum);

        System.out.println("\n4. Total Amount: " + total);

        // 5. Grouping - Count each product
        Map<String, Long> counts = products.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        TreeMap::new,
                        Collectors.counting()
                ));

        System.out.println("\n5. Product Counts:");
        System.out.println(counts);

        System.out.println("\nStreams Practice Completed!");
    }
}
