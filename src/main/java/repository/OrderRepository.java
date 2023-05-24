package repository;

import exception.OrderNotFoundException;
import exception.ProductNotFoundException;
import model.Order;
import model.Product;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository {

    private List<Order> orders;

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
}
