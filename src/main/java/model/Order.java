package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Order {

    private String id;
    private Map<String, Product> products;

    public Order(String id) {
        this.id = id;
        products = new HashMap<>(); // Muss initialisiert werden,
                                    // weil products sonst null ist
    }

    public Order(String id, Map<String, Product> products) {
        this.id = id;
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;

        return Objects.equals(id, order.id) && Objects.equals(products, order.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, products);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", products=" + products +
                '}';
    }
}
