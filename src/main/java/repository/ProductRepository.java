package repository;

import exception.ProductNotFoundException;
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

    public Product getProduct(String idOfRequestedProduct) {
        // Indices:  0              1                      2
        //          AppleKeyboard   Vorwerk Staubsauger    Les Paul Gitarre

        // for-each Schleife
        // Wir "schauen" uns die products Liste STück für Stück an
        // singleProductFromList -> Das Objekt aus der Liste das wir uns anschauen
        for (Product singleProductFromList: products) {
            if(singleProductFromList.getId().equals(idOfRequestedProduct)) {
                return singleProductFromList;
            }
        }

        // Wenn for-Schleife durchgelaufen ist, aber nichts gefunden hat ...
        // Soll eine Exception geworfen werden
        throw new ProductNotFoundException(idOfRequestedProduct);
    }
}
