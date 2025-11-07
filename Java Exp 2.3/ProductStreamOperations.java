import java.util.*;
import java.util.stream.*;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;

class Product {
    String name;
    double price;
    String category;

    public Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }
}

public class ProductStreamOperations {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", 80000, "Electronics"),
            new Product("Phone", 50000, "Electronics"),
            new Product("Shoes", 4000, "Fashion"),
            new Product("T-shirt", 1500, "Fashion"),
            new Product("Refrigerator", 60000, "Home Appliance"),
            new Product("Microwave", 8000, "Home Appliance")
        );

        System.out.println("Group Products by Category:");
        Map<String, List<Product>> grouped = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));
        grouped.forEach((cat, list) -> {
            System.out.println(cat + ": " + list.stream().map(Product::getName).collect(Collectors.joining(", ")));
        });

        System.out.println("\nMost Expensive Product in Each Category:");
        Map<String, Optional<Product>> maxPrice = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory,
                        Collectors.maxBy(Comparator.comparingDouble(Product::getPrice))));
        maxPrice.forEach((cat, prod) -> System.out.println(cat + ": " + prod.get().getName() + " - " + prod.get().getPrice()));

        double avgPrice = products.stream()
                .collect(Collectors.averagingDouble(Product::getPrice));
        System.out.println("\nAverage Price of All Products: " + avgPrice);
    }
}
