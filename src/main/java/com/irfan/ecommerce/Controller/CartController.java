package com.irfan.ecommerce.Controller;

import com.irfan.ecommerce.Entity.CartItemEntity;
import com.irfan.ecommerce.Service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart") // ✅ added /api
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    // Add item to cart
    @PostMapping("/add")
    public ResponseEntity<CartItemEntity> addToCart(@RequestBody CartItemEntity cartItem) {
        return ResponseEntity.ok(cartService.addToCart(cartItem));
    }

    // Get cart items by user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<CartItemEntity>> getUserCart(@PathVariable Long userId) {
        return ResponseEntity.ok(cartService.getCartItemsByUser(userId));
    }

    // Update quantity
    @PutMapping("/{cartItemId}")
    public ResponseEntity<CartItemEntity> updateQuantity(
            @PathVariable Long cartItemId,
            @RequestParam int quantity) {
        return ResponseEntity.ok(cartService.updateQuantity(cartItemId, quantity));
    }

    // Remove single item
    @DeleteMapping("/deletecartID/{cartItemId}")
    public ResponseEntity<String> removeItem(@PathVariable Long cartItemId) {
        cartService.removeItem(cartItemId);
        return ResponseEntity.ok("Item removed successfully");
    }

    // Clear entire cart
    @DeleteMapping("/clear/{userId}")
    public ResponseEntity<String> clearCart(@PathVariable Long userId) {
        cartService.clearCart(userId);
        return ResponseEntity.ok("Cart cleared successfully");
    }
}