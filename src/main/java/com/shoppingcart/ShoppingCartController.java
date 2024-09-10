package com.shoppingcart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @PostMapping("/add")
    public ResponseEntity<Item> addItemToCart(@RequestBody Item item) {
        Item addedItem = shoppingCartService.addItemToCart(item);
        return ResponseEntity.ok(addedItem);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Void> removeItemFromCart(@PathVariable Long id) {
        shoppingCartService.removeItemFromCart(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/items")
    public ResponseEntity<List<Item>> getAllItemsInCart() {
        return ResponseEntity.ok(shoppingCartService.getAllItemsInCart());
    }

    @GetMapping("/total")
    public ResponseEntity<Double> getTotalPrice() {
        return ResponseEntity.ok(shoppingCartService.getTotalPrice());
    }
}