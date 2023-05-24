package repository;

import model.Product;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    // Methodenname + should + then
    @Test
    void list_whenProductsMapIsEmpty_thenReturnEmptyList() {
        // Given - Ist Zustand
        // Instanz = Ein konkretes Objekt vom Typen
        ProductRepository productRepository = new ProductRepository();
        // Wie sieht die eigentlich erwartete Liste aus?
        List<Product> expectedProductList = new ArrayList<>();
        int expectedListLength = 0;

        // When - Unter welchen Umständen (bekommen wir die Liste?)
        List<Product> actualProductList = productRepository.list();

        // Then - Soll Zustand
        assertEquals(actualProductList, expectedProductList);
        assertEquals(expectedListLength, actualProductList.size());
    }

    @Test
    void list_whenProductsMapHasOneProduct_thenReturnListWithOneProduct() {
        // Given - Ist Zustand
        // Produkt erstellen
        Product appleKeyboard = new Product("1", "Apple Tastatur");

        // Erwartete ProduktLISTE erstellen
        List<Product> expectedProductList = new ArrayList<>();
        expectedProductList.add(appleKeyboard);
        int expectedListLength = 1;

        // Liste im Repo speicher
        ProductRepository productRepository = new ProductRepository(expectedProductList);

        // When - Unter welchen Umständen (bekommen wir die Liste?)
        List<Product> actualProductList = productRepository.list();

        // Then - Soll Zustand
        assertEquals(expectedProductList, actualProductList);
        assertEquals(expectedListLength, actualProductList.size());
    }
}