package de.neuefische.shopsystem.service;

import de.neuefische.shopsystem.exception.ProductNotFoundException;
import de.neuefische.shopsystem.model.Order;
import de.neuefische.shopsystem.model.Product;
import org.junit.jupiter.api.Test;
import de.neuefische.shopsystem.repository.OrderRepository;
import de.neuefische.shopsystem.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ShopServiceTest {


    @Test
    void getProductById_whenExistingId_thenReturnProduct() {
        //GIVEN

        //WHEN

        //THEN
    }

    @Test
    void listProducts_whenAtLeastOneProductExists_thenReturnProductList() {
        //GIVEN

        //WHEN

        //THEN
    }

    @Test
    void listOrders_whenNoOrdersExist_thenReturnEmptyList() {
        //GIVEN

        //WHEN

        //THEN
    }

    @Test
    void getOrderById_whenValidOrderId_thenReturnOrder() {
        //GIVEN

        //WHEN

        //THEN
    }

    @Test
    void addOrder_whenOrderWasPlacedSuccessfully_thenOrdersListLengthShouldBeIncremented() {
        //GIVEN

        //WHEN

        //THEN
    }

    // BONUS
    @Test
    void getProductById_whenNonExistingId_thenThrowProductNotFoundException() {
        //GIVEN

        //WHEN + THEN
    }

    // BONUS
    @Test
    void getOrderById_whenNonExistingId_thenThrowOrderNotFoundException() {
        //GIVEN

        //WHEN + THEN
    }

}