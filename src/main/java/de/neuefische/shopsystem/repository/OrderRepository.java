package de.neuefische.shopsystem.repository;

import de.neuefische.shopsystem.exception.OrderNotFoundException;
import de.neuefische.shopsystem.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository {

    private final List<Order> orders;

    public OrderRepository() {
        orders = new ArrayList<>();
    }

    public OrderRepository(List<Order> orders) {
        this.orders = orders;
    }

    public List<Order> list() {
        return orders;
    }

    public Order getOrderById(String idOfRequestedOrder) {
        // for-each Schleife
        // Wir "schauen" uns die orders Liste Stück für Stück an
        // singleOrderFromList -> Das Objekt aus der Liste das wir uns anschauen
        for (Order singleOrderFromList: orders) {
            if(singleOrderFromList.getId().equals(idOfRequestedOrder)) {
                return singleOrderFromList;
            }
        }

        // Wenn for-Schleife durchgelaufen ist, aber nichts gefunden hat ...
        // Soll eine Exception geworfen werden
        throw new OrderNotFoundException(idOfRequestedOrder);
    }

    public void addOrder(Order orderToAdd) {
        orders.add(orderToAdd);
    }
}
