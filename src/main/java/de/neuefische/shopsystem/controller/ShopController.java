package de.neuefische.shopsystem.controller;

import de.neuefische.shopsystem.model.Order;
import de.neuefische.shopsystem.model.Product;
import de.neuefische.shopsystem.service.ShopService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shop")
public class ShopController {

    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping("/products")
    public List<Product> allProducts(){
        return shopService.listProducts();
    }

    @GetMapping("/products/{id}")
    public Product getSingleProduct(@PathVariable String id){
        return shopService.getProductById(id);
    }

    @GetMapping("/orders")
    public List<Order> allOrders(){
        return shopService.listOrders();
    }

    @GetMapping("/orders/{id}")
    public Order getSingleOrder(@PathVariable String id){
        return shopService.getOrderById(id);
    }

    @PostMapping("/orders")
    public void addOrder(@RequestBody Order order){
        shopService.addOrder(order);
    }

}
