package de.neuefische.shopsystem.exception;

import java.util.NoSuchElementException;

public class OrderNotFoundException extends NoSuchElementException {

    public OrderNotFoundException(String id) {
        super("Order mit der ID " + id + " konnte nicht gefunden werden.");
    }
}