package de.neuefische.shopsystem.repository;

import de.neuefische.shopsystem.exception.OrderNotFoundException;
import de.neuefische.shopsystem.model.Order;
import de.neuefische.shopsystem.model.Product;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderRepositoryTest {

    @Test
    void list_whenOrdersRepositoryIsEmpty_thenReturnEmptyList() {
        // GIVEN
        OrderRepository orderRepository = new OrderRepository();
        List<Order> expectedOrders = new ArrayList<>();

        int expectedListLength = 0;

        // WHEN
        List<Order> actualOrders = orderRepository.list();

        // THEN
        assertEquals(expectedOrders, actualOrders);
        assertEquals(expectedListLength, actualOrders.size());
    }

    @Test
    void list_whenOrdersRepositoryHasTwoItems_thenReturnListWithTwoItems() {
        // GIVEN
        List<Order> expectedOrders = new ArrayList<>();

        List<Product> listOfProducts1 = Arrays.asList(new Product("1-Technik", "Apple Tastatur"), new Product("2-Technik", "Apple Maus"));
        List<Product> listOfProducts2 = Arrays.asList(new Product("1-Wein", "Georgischer Rotwein"), new Product("2-Wein", "Franz. Chardonnay"));


        Order order1 = new Order("1-Order", listOfProducts1);
        Order order2 = new Order("2-Order", listOfProducts2);

        expectedOrders.add(order1);
        expectedOrders.add(order2);

        OrderRepository orderRepository = new OrderRepository(expectedOrders);

        // WHEN
        List<Order> actualOrders = orderRepository.list();

        // THEN
        assertEquals(expectedOrders, actualOrders);
    }

    @Test
    void getOrderById_whenOrderExistsInList_thenReturnValidOrder() {
        // GIVEN
        List<Order> expectedOrders = new ArrayList<>();

        List<Product> listOfProducts1 = Arrays.asList(new Product("1-Technik", "Apple Tastatur"), new Product("2-Technik", "Apple Maus"));
        List<Product> listOfProducts2 = Arrays.asList(new Product("1-Wein", "Georgischer Rotwein"), new Product("2-Wein", "Franz. Chardonnay"));


        Order order1 = new Order("1-Order", listOfProducts1);
        Order expectedOrder = new Order("2-Order", listOfProducts2);

        expectedOrders.add(order1);
        expectedOrders.add(expectedOrder);

        OrderRepository orderRepository = new OrderRepository(expectedOrders);
        String requestedOrderId = expectedOrder.getId();

        // WHEN
        Order requestedOrder = orderRepository.getOrderById(requestedOrderId);

        // THEN
        assertEquals(expectedOrder, requestedOrder);
    }

    @Test
    void getOrderById_whenOrderDoesntExistInList_thenThrowOrderNotFoundException() {
        // GIVEN
        List<Order> expectedOrders = new ArrayList<>();

        OrderRepository orderRepository = new OrderRepository(expectedOrders);
        String requestedOrderId = "Diese Order ID existiert nicht, haha";

        // WHEN + THEN
        assertThrows(OrderNotFoundException.class, () -> orderRepository.getOrderById(requestedOrderId));
    }

    @Test
    void addOrder_whenOrderWasPlacedSuccessfully_thenOrdersListLengthShouldBeIncremented() {
        // GIVEN
        OrderRepository orderRepository = new OrderRepository();
        int initialOrdersListLength = orderRepository.list().size();

        // WHEN
        List<Product> listOfProducts1 = Arrays.asList(new Product("1-Technik", "Apple Tastatur"), new Product("2-Technik", "Apple Maus"));
        Order order1 = new Order("1-Order", listOfProducts1);
        orderRepository.addOrder(order1);

        // THEN
        int incrementedOrdersListLength = orderRepository.list().size();

        assertEquals(incrementedOrdersListLength, initialOrdersListLength + 1);
    }
}