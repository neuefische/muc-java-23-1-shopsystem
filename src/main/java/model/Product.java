package model;

import java.util.Objects;

// Klasse, eigener Typ der Fachlichkeit beschreibt
// POJO = Plain Old Java Object
public class Product {

    // 1. Attribute = Eigenschaften der Klasse
    private String id;
    private String name;

    // 2. Konstruktoren
    public Product(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // 3. Öffentlichen Methoden

    // 4. Privaten Methoden

    // 5. Methoden die sich immer wiederholen - toString equals (Boilerplate Code)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
