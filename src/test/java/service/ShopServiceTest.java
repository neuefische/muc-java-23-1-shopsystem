package service;

import model.Order;
import model.Product;
import org.junit.jupiter.api.Test;
import repository.OrderRepository;
import repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShopServiceTest {

    @Test
    void getProduct_whenNonExistingId_thenReturnNull() {
        //GIVEN
        List<Order> order = new ArrayList<>();
        OrderRepository orderRepository = new OrderRepository(order);
        List<Product> products = new ArrayList<>();
        ProductRepository productRepository = new ProductRepository(products);

        ShopService shopService = new ShopService(productRepository, orderRepository);

        //WHEN
        Product actual = shopService.getProductById("nonExistingId");

        //THEN
        Product expected = null;
        assertEquals(expected, actual);
    }

    @Test
    void getProduct_whenExistingId_thenReturnProduct() {
        //GIVEN
        List<Order> order = new ArrayList<>();
        OrderRepository orderRepository = new OrderRepository(order);

        Product product1 = new Product("Banane", "123");
        List<Product> products = new ArrayList<>();
        products.add(product1);

        ProductRepository productRepository = new ProductRepository(products);

        ShopService shopService = new ShopService(productRepository, orderRepository);

        //WHEN
        Product actual = shopService.getProductById("123");

        //THEN
        Product expected = new Product("Banane", "123");
        assertEquals(expected, actual);
    }

    @Test
    void listProducts_thenReturnProductList() {
        //GIVEN
        List<Order> order = new ArrayList<>();
        OrderRepository orderRepository = new OrderRepository(order);

        Product product1 = new Product("Banane", "123");
        List<Product> products = new ArrayList<>();
        products.add(product1);

        ProductRepository productRepository = new ProductRepository(products);

        ShopService shopService = new ShopService(productRepository, orderRepository);

        //WHEN
        List<Product> actual = shopService.listProducts();

        //THEN
        List<Product> expected = new ArrayList<>(products);
        assertEquals(expected, actual);
    }

    @Test
    void listOrders_whenNoOrdersExist_thenReturnEmptyList() {
        //GIVEN
        List<Order> orders = new ArrayList<>();
        OrderRepository orderRepository = new OrderRepository(orders);

        Product product1 = new Product("Banane", "123");
        List<Product> products = new ArrayList<>();
        products.add(product1);

        ProductRepository productRepository = new ProductRepository(products);

        ShopService shopService = new ShopService(productRepository, orderRepository);

        //WHEN
        List<Order> actual = shopService.listOrders();

        //THEN
        List<Order> expected = new ArrayList<>(orders);
        assertEquals(expected, actual);
    }

    @Test
    void getOrderById_whenValidOrderId_thenReturnOrder() {
        //GIVEN
        Product product1 = new Product("Banane", "123");
        List<Product> products = new ArrayList<>();
        products.add(product1);

        ProductRepository productRepository = new ProductRepository(products);

        List<Order> orders = new ArrayList<>();
        Order order = new Order("123456", products);
        orders.add(order);

        OrderRepository orderRepository = new OrderRepository(orders);

        ShopService shopService = new ShopService(productRepository, orderRepository);

        //WHEN
        Order actual = shopService.getOrderById("123456");

        //THEN
        Order expected = new Order("123456", products);
        assertEquals(expected, actual);
    }

    @Test
    void addOrder_whenOrderWasPlacedSuccessfully_thenOrdersListLengthShouldBeIncremented() {
        //GIVEN
        Product product1 = new Product("Apfel", "123456");
        Product product2 = new Product("Birne", "123");

        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);

        ProductRepository productRepository = new ProductRepository(products);

        List<Order> orders = new ArrayList<>();
        OrderRepository orderRepository = new OrderRepository(orders);

        ShopService shopService = new ShopService(productRepository, orderRepository);
        int initialOrdersListSize = shopService.listOrders().size();

        int expectedInitialLength = 2;
        int expectedIncrementedLength = 3;

        //WHEN
        String orderId = "ABC13";
        shopService.addOrder(new Order(orderId));
        int incrementedOrdersListSize = shopService.listOrders().size();

        //THEN
        assertEquals(expectedInitialLength, initialOrdersListSize);
        assertEquals(expectedIncrementedLength, incrementedOrdersListSize);
    }

}