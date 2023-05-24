package repository;

import model.Product;

import java.util.ArrayList;
import java.util.List;


// Repository - Klasse die auf gespeicherte Daten zugreift
// Product Repository kümmert sich um ... Zugriff auf "Product" Daten
public class ProductRepository {

    private List<Product> products;

    public ProductRepository() {
        products = new ArrayList<>();
    }

    public ProductRepository(List<Product> products) {
        this.products = products;
    }

    public List<Product> list() {
        return products;
    }
}
