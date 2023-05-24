package service;

import model.Order;
import model.Product;
import repository.OrderRepository;
import repository.ProductRepository;

import java.util.List;

public class ShopService {

    // Abhängigkeiten -> Der ShopService BRAUCHT diese Repositories
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public ShopService(ProductRepository productRepository, OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    public Order getOrderById(String id) {
        return orderRepository.getOrderById(id);
    }

    public Product getProductById(String id) {
        return productRepository.getProductById(id);
    }

    public List<Product> listProducts() {
        return productRepository.list();
    }

    // ShopService greift auf das Repository zu
    public List<Order> listOrders() {
        return orderRepository.list();
    }

    public void addOrder(Order orderToAdd) {
        orderRepository.addOrder(orderToAdd);
    }
}
