package exception;

import java.util.NoSuchElementException;

public class ProductNotFoundException extends NoSuchElementException {

    public ProductNotFoundException(String id) {
        super("Produkt mit der ID " + id + " konnte nicht gefunden werden.");
    }
}
