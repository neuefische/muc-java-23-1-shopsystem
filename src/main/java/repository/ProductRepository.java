package repository;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Repository - Klasse die auf gespeicherte Daten zugreift
// Product Repository kümmert sich um ... Zugriff auf "Product" Daten
public class ProductRepository {

    private Map<String, Product> products;

    public ProductRepository() {
        products = new HashMap<>();
    }

    public List<Product> list() {
        return new ArrayList<Product>(products.values());
    }
}
