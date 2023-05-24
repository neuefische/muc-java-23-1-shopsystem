package repository;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository {

    private List<Product> orders;

    public OrderRepository() {
        orders = new ArrayList<>();
    }

    public OrderRepository(List<Product> orders) {
        this.orders = orders;
    }

    public List<Product> list() {
        return orders;
    }
}
