package repository;

import exception.ProductNotFoundException;
import model.Product;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    // Methodenname + when + then
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

    @Test
    void list_whenProductsMapHasTwoProducts_thenReturnListWithTwoProducts() {
        // Given - Ist Zustand
        // Produkt erstellen
        Product appleKeyboard = new Product("1", "Apple Tastatur");
        Product appleMouse = new Product("2", "Apple Maus");

        // Erwartete ProduktLISTE erstellen
        List<Product> expectedProductList = new ArrayList<>();
        expectedProductList.add(appleKeyboard);
        expectedProductList.add(appleMouse);
        int expectedListLength = 2;

        // Liste im Repo speicher
        ProductRepository productRepository = new ProductRepository(expectedProductList);

        // When - Unter welchen Umständen (bekommen wir die Liste?)
        List<Product> actualProductList = productRepository.list();

        // Then - Soll Zustand
        assertEquals(expectedProductList, actualProductList);
        assertEquals(expectedListLength, actualProductList.size());
    }

    @Test
    void getProductById_whenProductExistsInList_thenReturnValidProduct() {
        // Given - Ist Zustand
        Product appleKeyboard = new Product("1", "Apple Tastatur");
        Product expectedProduct = new Product("2", "Apple Maus");
        String expectedId = expectedProduct.getId();

        List<Product> expectedProductList = new ArrayList<>();
        expectedProductList.add(appleKeyboard);
        expectedProductList.add(expectedProduct);


        ProductRepository productRepository = new ProductRepository(expectedProductList);

        // When
        Product actualProduct = productRepository.getProductById(expectedId);

        // Then
        assertEquals(expectedProduct, actualProduct);
    }

    @Test
    void getProductById_whenProductDoesntExist_thenThrowException() {
        // Given - Ist Zustand
        List<Product> expectedProductList = new ArrayList<>();

        // Zur Verdeutlichung: Das erwartete Produkt ist die Apple Maus.
        // Normalerweose
        String expectedId = "Diese ID gibt es nicht und die Liste ist eh leer.";

        ProductRepository productRepository = new ProductRepository(expectedProductList);

        // When + Then
        assertThrows(ProductNotFoundException.class, () -> productRepository.getProductById(expectedId));
    }
}