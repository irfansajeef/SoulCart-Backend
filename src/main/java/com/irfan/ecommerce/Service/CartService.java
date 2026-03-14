package com.irfan.ecommerce.Service;

import com.irfan.ecommerce.Entity.CartEntity;
import com.irfan.ecommerce.Entity.CartItemEntity;
import com.irfan.ecommerce.Entity.ProductEntity;
import com.irfan.ecommerce.Repository.CartItemRepository;
import com.irfan.ecommerce.Repository.CartRepository;
import com.irfan.ecommerce.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public CartItemEntity addToCart(CartItemEntity cartItem) {
        // 1. Extract IDs from the incoming request
        Long userId = cartItem.getCart().getUser().getId();
        Long productId = (long) cartItem.getProduct().getId();

        // 2. FIND the user's cart, or CREATE a new one if it doesn't exist
        // This prevents the "Cart not found!" exception
        CartEntity cart = cartRepository.findByUserId(userId)
                .orElseGet(() -> {
                    CartEntity newCart = new CartEntity();
                    newCart.setUser(cartItem.getCart().getUser());
                    return cartRepository.save(newCart);
                });

        // 3. Fetch the real ProductEntity from DB
        ProductEntity product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + productId));

        // 4. CHECK if the product is already in the cart to update quantity instead of adding a new row
        Optional<CartItemEntity> existingItem = cartItemRepository.findByCartAndProduct(cart, product);

        if (existingItem.isPresent()) {
            CartItemEntity itemToUpdate = existingItem.get();
            itemToUpdate.setQuantity(itemToUpdate.getQuantity() + cartItem.getQuantity());
            return cartItemRepository.save(itemToUpdate);
        } else {
            // 5. Set real managed entities and save new item
            cartItem.setCart(cart);
            cartItem.setProduct(product);
            return cartItemRepository.save(cartItem);
        }
    }

    public List<CartItemEntity> getCartItemsByUser(Long userId) {
        return cartItemRepository.findByCart_UserId(userId);
    }

    public CartItemEntity updateQuantity(Long itemId, int quantity) {
        CartItemEntity item = cartItemRepository.findById(itemId)
                .orElseThrow(() -> new RuntimeException("Item not found"));
        item.setQuantity(quantity);
        return cartItemRepository.save(item);
    }

    public void removeItem(Long itemId) {
        cartItemRepository.deleteById(itemId);
    }

    public void clearCart(Long userId) {
        List<CartItemEntity> items = cartItemRepository.findByCart_UserId(userId);
        cartItemRepository.deleteAll(items);
    }
}