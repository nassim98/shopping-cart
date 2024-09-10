package com.shoppingcart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartService {

    @Autowired
    private ItemRepository itemRepository;

    public Item addItemToCart(Item item) {
        return itemRepository.save(item);
    }

    public void removeItemFromCart(Long id) {
        itemRepository.deleteById(id);
    }

    public List<Item> getAllItemsInCart() {
        return itemRepository.findAll();
    }

    public Double getTotalPrice() {
        return itemRepository.findAll().stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .sum();
    }
}