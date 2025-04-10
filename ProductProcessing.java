// File: ProductProcessing.java
import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import java.util.Map.Entry;

class Product {
    private String name;
    private String category;
    private double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return "Product{name='" + name + "', category='" + category + "', price=" + price + "}";
    }
}

public class ProductProcessing {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", "Electronics", 900),
                new Product("Phone", "Electronics", 700),
                new Product("Shirt", "Clothing", 40),
                new Product("Jeans", "Clothing", 60),
                new Product("Sofa", "Furniture", 300),
                new Product("Table", "Furniture", 150)
        );

        // Group by category
        Map<String, List<Product>> groupedByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));
        System.out.println("Grouped by category:");
        groupedByCategory.forEach((cat, list) -> {
            System.out.println(cat + ": " + list);
        });

        // Most expensive product per category
        System.out.println("\nMost expensive product in each category:");
        Map<String, Optional<Product>> maxByCategory = products.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.maxBy(Comparator.comparingDouble(Product::getPrice))
                ));
        maxByCategory.forEach((category, product) ->
                System.out.println(category + ": " + product.orElse(null))
        );

        // Average price
        double avgPrice = products.stream()
                .mapToDouble(Product::getPrice)
                .average()
                .orElse(0.0);
        System.out.println("\nAverage price of all products: " + avgPrice);
    }
}
