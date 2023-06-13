package de.neuefische.shopsystem.controller;

import de.neuefische.shopsystem.model.Product;
import de.neuefische.shopsystem.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.converter.json.Jackson2ObjectMapperBuilder.json;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

@AutoConfigureMockMvc
@SpringBootTest
class ShopControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ProductRepository productRepository;

    @Test
    @DirtiesContext
    void allProducts() throws Exception {
        productRepository.addAll(List.of(new Product("Product-1", "Georgischer Rotwein"), new Product("Product-2", "Franz. Chardonnay"), new Product("Product-3", "Adiletten"), new Product("Product-4", "Bademantel"), new Product("Product-5", "Apple Keyboard")));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/shop/products"))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                               [{"id":"Product-1","name":"Georgischer Rotwein"},{"id":"Product-2","name":"Franz. Chardonnay"},{"id":"Product-3","name":"Adiletten"},{"id":"Product-4","name":"Bademantel"},{"id":"Product-5","name":"Apple Keyboard"}]
                        """))
                .andExpect(jsonPath("$.length()").value(productRepository.list().size()));
    }

    @Test
    void allProductsEmpty() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/shop/products"))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                                []
                        """))
                .andExpect(jsonPath("$.length()").value(0));
    }
}